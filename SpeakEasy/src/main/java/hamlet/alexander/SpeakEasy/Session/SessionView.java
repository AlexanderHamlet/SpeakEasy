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

    private static final String FRONTPAGE = "SpeakEasy";
    private static final String HOME = "home";
    private static final String FORUM = "forum";
    private static final String POST = "post";
    private static final String NOT_FOUND_404 = "404";

    public String displaySubmission(Submission parentSubmission, Submission submission, User user, List<Submission> children, Model model) {
        String display = NOT_FOUND_404;

        if(submission.getClass() == Forum.class) {
            display = displayForum((Forum)submission, user, children, model);
        }

        if(submission.getClass() == Post.class) {
            display = displayPost((Forum) parentSubmission, (Post)submission, user, children, model);
        }

        return display;
    }

    public String displayForum(Forum forum, User user, List<Submission> children, Model model) {
        String display = FORUM;

        if (forum.getTitle().equals(FRONTPAGE)) {
            display = HOME;
        }

        model.addAttribute("forumTitle", forum.getTitle());
        model.addAttribute("description", forum.getBody());
        model.addAttribute("user", user.getUserName());
        model.addAttribute("children", children);
        return display;
    }

    public String displayPost(Forum forum, Post post, User user, List<Submission> children, Model model) {
        String display = POST;

        model.addAttribute("title", post.getTitle());
        model.addAttribute("description", post.getBody());
        model.addAttribute("user", user.getUserName());
        model.addAttribute("children", children);
        return display;
    }

    public String display404() {
        return NOT_FOUND_404;
    }
}
