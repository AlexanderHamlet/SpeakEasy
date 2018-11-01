package hamlet.alexander.SpeakEasy.Session;

import hamlet.alexander.SpeakEasy.Submission.Comment;
import hamlet.alexander.SpeakEasy.Submission.Forum;
import hamlet.alexander.SpeakEasy.Submission.Post;
import hamlet.alexander.SpeakEasy.Submission.Submission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class SessionController {

    @Autowired
    private Session session;

    @GetMapping("/")
    public String home(Model model) {

        Submission forum1 = new Forum(1, "FORUM 1", "This is the description of Forum 1");
        session.getSubmission().addChild(forum1);

        String submissionTitle = session.getSubmission().getTitle();
        List<HashMap<String, String>> submissionChildren = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> hash1 = new HashMap<String, String>();
        hash1.put("title", session.getSubmission().getChildren().get(0).getTitle());
        hash1.put("body", session.getSubmission().getChildren().get(0).getBody());
        submissionChildren.add(hash1);
        String userName = session.getUser().getUserName();

        model.addAttribute("title", submissionTitle);
        model.addAttribute("user", userName);
        model.addAttribute("children", submissionChildren);

        return "home";
    }

    @GetMapping("/forum1")
    public String forumOne(Model model) {
        Submission forum1 = new Forum(1, "FORUM 1", "This is the description of Forum 1");
        session.getSubmission().addChild(forum1);

        session.setSubmission(session.getSubmission().getChildren().get(0));

        Submission post1 = new Post("Post 1", "This is the body of Post 1");
        Submission post2 = new Post("Post 2", "This is the body of Post 2");
        session.getSubmission().addChild(post1);
        session.getSubmission().addChild(post2);

        String submissionTitle = session.getSubmission().getTitle();
        List<HashMap<String, String>> submissionChildren = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> hash1 = new HashMap<String, String>();
        hash1.put("title", session.getSubmission().getChildren().get(0).getTitle());
        hash1.put("body", session.getSubmission().getChildren().get(0).getBody());
        HashMap<String, String> hash2 = new HashMap<String, String>();
        hash2.put("title", session.getSubmission().getChildren().get(1).getTitle());
        hash2.put("body", session.getSubmission().getChildren().get(1).getBody());
        submissionChildren.add(hash1);
        submissionChildren.add(hash2);
        String userName = session.getUser().getUserName();

        model.addAttribute("title", submissionTitle);
        model.addAttribute("user", userName);
        model.addAttribute("children", submissionChildren);

        return "home";
    }

    @GetMapping("/forum1/post1")
    public String postOne(Model model) {
        Submission forum1 = new Forum(1, "FORUM 1", "This is the description of Forum 1");
        session.getSubmission().addChild(forum1);

        session.setSubmission(session.getSubmission().getChildren().get(0));

        Submission post1 = new Post("Post 1", "This is the body of Post 1");
        Submission post2 = new Post("Post 2", "This is the body of Post 2");
        session.getSubmission().addChild(post1);
        session.getSubmission().addChild(post2);

        session.setSubmission(session.getSubmission().getChildren().get(0));

        Submission comment1 = new Comment("This is the first comment.");
        Submission comment2 = new Comment("This is the second comment.");
        session.getSubmission().addChild(comment1);
        session.getSubmission().addChild(comment2);

        String submissionTitle = session.getSubmission().getTitle();
        List<HashMap<String, String>> submissionChildren = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> hash1 = new HashMap<String, String>();
        hash1.put("title", session.getSubmission().getChildren().get(0).getTitle());
        hash1.put("body", session.getSubmission().getChildren().get(0).getBody());
        HashMap<String, String> hash2 = new HashMap<String, String>();
        hash2.put("title", session.getSubmission().getChildren().get(1).getTitle());
        hash2.put("body", session.getSubmission().getChildren().get(1).getBody());
        submissionChildren.add(hash1);
        submissionChildren.add(hash2);
        String userName = session.getUser().getUserName();

        model.addAttribute("title", submissionTitle);
        model.addAttribute("user", userName);
        model.addAttribute("children", submissionChildren);

        return "home";
    }

}
