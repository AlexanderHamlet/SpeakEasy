package hamlet.alexander.SpeakEasy.Session;

import hamlet.alexander.SpeakEasy.Submission.*;
import hamlet.alexander.SpeakEasy.User.User;

import hamlet.alexander.SpeakEasy.User.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class SessionController {

    @Autowired
    private Session session;

    @Autowired
    private SessionView sessionView;

    @Autowired
    private UserService userService;

    @Autowired
    private SubmissionService submissionService;

    /*@GetMapping(value = "/")
    public String speakEasy(Model model) {
        User admin = new User("admin", "password", "admin");
        userService.save(admin);
        Forum nullParent = new Forum(new ObjectId(), userService.findByUserName("admin").getId(), "SpeakEasyParent", "Admin page.");
        submissionService.save(nullParent);
        Forum SE = new Forum(submissionService.findByForumTitle("SpeakEasyParent").getId(), userService.findByUserName("admin").getId(), "SpeakEasy", "Welcome to the frontpage of SpeakEasy! SpeakEasy is a place to share and discuss ideas with others of likeminded interest. Please be civil.");
        submissionService.save(SE);
        session.setUser(userService.findByUserName("admin"));
        session.setSubmission(submissionService.findByForumTitle("SpeakEasy"));
        model.addAttribute("forumTitle", session.getSubmission().getTitle());
        model.addAttribute("description", session.getSubmission().getBody());
        model.addAttribute("user", session.getUser().getUserName());
        model.addAttribute("children", submissionService.findByParentId(session.getSubmission().getId()));
        return "home";
    }//*/

    @GetMapping(value = "/{forum}")
    public String forum(@PathVariable String forum, Model model) {
        try {
            session.setSubmission(submissionService.findByForumTitle(forum));
        } catch(NullPointerException e) {
            return sessionView.display404();
        }

        return sessionView.displayForum((Forum)session.getSubmission(), session.getUser(), submissionService.findByParentId(session.getSubmission().getId()), model);
    }

    @GetMapping(value = "/{forum}/{post}")
    public String post(@PathVariable String forum, @PathVariable String post, Model model) {
        try {
            Forum parentForum = submissionService.findByForumTitle(forum);
            Post fullPost = submissionService.findByPostTitle(post);
            if (parentForum.getId().equals(fullPost.getParentId())) {
                session.setSubmission(fullPost);
                return sessionView.displayPost(parentForum, (Post) session.getSubmission(), session.getUser(), submissionService.findByParentId(session.getSubmission().getId()), model);
            }
        } catch (NullPointerException e) {
            return sessionView.display404();
        }

        return sessionView.display404();
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam Map<String, String> credentials, Model model) {
        User user = userService.findByUserName(credentials.get("username"));
        if(user != null && user.getPassword().equals(credentials.get("password"))) {
            session.setUser(user);
        }

        return sessionView.displaySubmission(submissionService.findById(session.getSubmission().getParentId()),
                session.getSubmission(),
                session.getUser(),
                submissionService.findByParentId(session.getSubmission().getId()),
                model);
    }

    @PostMapping(value = "/signup")
    public String signUp(@RequestParam Map<String, String> credentials, Model model) {
        if(userService.findByUserName(credentials.get("username")) == null) {
            userService.save(new User(credentials.get("username"), credentials.get("password"), credentials.get("role")));
            session.setUser(userService.findByUserName(credentials.get("username")));
        }

        return sessionView.displaySubmission(submissionService.findById(session.getSubmission().getParentId()),
                session.getSubmission(),
                session.getUser(),
                submissionService.findByParentId(session.getSubmission().getId()),
                model);
    }

    @PostMapping(value = "/submit")
    public String submit(@RequestParam Map<String, String> submissionDetails, Model model) {
        if(!session.getUser().getRole().equals("logged-out")) {
            if(session.getSubmission().getTitle().equals("SpeakEasy")) {
                submissionService.save(new Forum(session.getSubmission().getId(), session.getUser().getId(), submissionDetails.get("title"), submissionDetails.get("body")));
            } else if(session.getSubmission().getClass().equals(Forum.class)) {
                submissionService.save(new Post(session.getSubmission().getId(), session.getUser().getId(), submissionDetails.get("title"), submissionDetails.get("body")));
            } else {
                submissionService.save(new Comment(session.getSubmission().getId(), session.getUser().getId(), submissionDetails.get("body")));
            }
        }

        return sessionView.displaySubmission(submissionService.findById(session.getSubmission().getParentId()),
                session.getSubmission(),
                session.getUser(),
                submissionService.findByParentId(session.getSubmission().getId()),
                model);
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam Map<String, String> deleteDetails, Model model) {
        String type = deleteDetails.get("type_to_delete");
        String submissionToDeleteId = deleteDetails.get("delete_submission_title");
        Submission submissionToDelete = null;

        try {
            if (type.equals("forum")) {
                submissionToDelete = submissionService.findByForumTitle(submissionToDeleteId);
            } else if (type.equals("post")) {
                submissionToDelete = submissionService.findByPostTitle(submissionToDeleteId);
            }
        } catch (NullPointerException e) {
            return sessionView.display404();
        }

        User user = session.getUser();
        try {
            if (user.getRole().equals("admin") || submissionToDelete.getPosterId() == user.getId()) {
                List<Submission> children = submissionService.findByParentId(submissionToDelete.getId());
                for (Submission child : children) {
                    submissionService.delete(child.getId());
                }

                submissionService.delete(submissionToDelete.getId());
            }
        } catch (NullPointerException e) {
            return sessionView.display404();
        }

        if (submissionToDelete.getId().equals(session.getSubmission().getId())) {
            session.setSubmission(submissionService.findByForumTitle("SpeakEasy"));
        }

        return sessionView.displaySubmission(submissionService.findById(session.getSubmission().getParentId()),
                session.getSubmission(),
                session.getUser(),
                submissionService.findByParentId(session.getSubmission().getId()),
                model);
    }

}
