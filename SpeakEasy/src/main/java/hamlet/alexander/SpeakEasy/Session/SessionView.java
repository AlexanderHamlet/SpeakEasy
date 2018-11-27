package hamlet.alexander.SpeakEasy.Session;

import hamlet.alexander.SpeakEasy.Submission.Forum;
import hamlet.alexander.SpeakEasy.Submission.Post;
import hamlet.alexander.SpeakEasy.Submission.Submission;
import hamlet.alexander.SpeakEasy.User.User;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.List;

@Component
public class SessionView {

    public String displaySubmission(Submission submission, User user, List<Submission> children, Model model) {
        String display = "404";

        if(submission.getClass() == Forum.class) {
            display = displayForum((Forum)submission, user, children, model);
        }

        if(submission.getClass() == Post.class) {
            display = displayPost((Post)submission, user, children, model);
        }

        return display;
    }

    public String displayForum(Forum forum, User user, List<Submission> children, Model model) {

        model.addAttribute("title", forum.getTitle());
        model.addAttribute("description", forum.getBody());
        model.addAttribute("user", user.getUserName());
        model.addAttribute("children", children);
        return "home";
    }

    public String displayPost(Post post, User user, List<Submission> children, Model model) {
        model.addAttribute("title", post.getTitle());
        model.addAttribute("description", post.getBody());
        model.addAttribute("user", user.getUserName());
        model.addAttribute("children", children);
        return "home";
    }
}
