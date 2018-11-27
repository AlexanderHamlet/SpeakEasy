package hamlet.alexander.SpeakEasy.Session;

import hamlet.alexander.SpeakEasy.Submission.*;
import hamlet.alexander.SpeakEasy.User.User;
import hamlet.alexander.SpeakEasy.User.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class SessionController {

    @Autowired
    private Session session;

    @Autowired
    private SessionView sessionView;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubmissionService submissionService;

    /*@GetMapping(value = "/")
    public String speakEasy(Model model) {
        User admin = new User("admin", "password", "admin");
        userRepository.save(admin);
        Forum SE = new Forum(new ObjectId(), userRepository.findByUserName("admin").getId(), "SpeakEasy", "Welcome to the frontpage of SpeakEasy! SpeakEasy is a place to share and discuss ideas with others of likeminded interest. Please be civil.");
        submissionService.save(SE);
        session.setUser(userRepository.findByUserName("admin"));
        session.setSubmission(submissionService.findByForumTitle("SpeakEasy"));
        model.addAttribute("title", session.getSubmission().getTitle());
        model.addAttribute("description", session.getSubmission().getBody());
        model.addAttribute("user", session.getUser().getUserName());
        model.addAttribute("children", submissionService.findByParentId(session.getSubmission().getId()));
        return "home";
    }*/

    @GetMapping(value = "/{forum}")
    public String forum(@PathVariable String forum, Model model) {
        session.setSubmission(submissionService.findByForumTitle(forum));
        return sessionView.displayForum((Forum)session.getSubmission(), session.getUser(), submissionService.findByParentId(session.getSubmission().getId()), model);
    }

    @GetMapping(value = "/{forum}/{post}")
    public String post(@PathVariable String forum, @PathVariable String post, Model model) {
        session.setSubmission(submissionService.findByPostTitle(post));
        return sessionView.displayPost((Post) session.getSubmission(), session.getUser(), submissionService.findByParentId(session.getSubmission().getId()), model);
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam Map<String, String> credentials, Model model) {
        User user = userRepository.findByUserName(credentials.get("username"));
        if(user != null && user.getPassword().equals(credentials.get("password"))) {
            session.setUser(user);
        }

        return sessionView.displaySubmission(session.getSubmission(), session.getUser(), submissionService.findByParentId(session.getSubmission().getId()), model);
    }

    @PostMapping(value = "/signup")
    public String signUp(@RequestParam Map<String, String> credentials, Model model) {
        if(userRepository.findByUserName(credentials.get("username")) == null) {
            userRepository.save(new User(credentials.get("username"), credentials.get("password"), credentials.get("role")));
            session.setUser(userRepository.findByUserName(credentials.get("username")));
        }

        return sessionView.displaySubmission(session.getSubmission(), session.getUser(), submissionService.findByParentId(session.getSubmission().getId()), model);
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

        return sessionView.displaySubmission(session.getSubmission(), session.getUser(), submissionService.findByParentId(session.getSubmission().getId()), model);
    }

}
