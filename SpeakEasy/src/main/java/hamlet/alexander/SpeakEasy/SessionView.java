package hamlet.alexander.SpeakEasy;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.List;

/**
 * MODEL VIEW CONTROLLER DESIGN PATTER: View
 *
 * The SessionView is the object that handles setting up
 * each page, and displaying each page for viewing. To
 * make the website view work accordingly, the SessionView
 * uses mustache templates to display the different pages.
 * Those can be found under ..../src/main/resources/templates.
 */
@Component
public class SessionView {

    private static final String FRONTPAGE = "SpeakEasy";
    private static final String HOME = "home";
    private static final String FORUM = "forum";
    private static final String POST = "post";
    private static final String NOT_FOUND_404 = "404";

    /**
     * Displays an unspecified submission type. Relies on displayForum and displayPost to do so.
     *
     * @param parentSubmission
     * @param submission
     * @param user
     * @param children
     * @param model
     * @return
     */
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

    /**
     * Displays the Forum object given.
     *
     * @param forum
     * @param user
     * @param children
     * @param model
     * @return
     */
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

    /**
     * Displays the post object given.
     *
     * @param forum
     * @param post
     * @param user
     * @param children
     * @param model
     * @return
     */
    public String displayPost(Forum forum, Post post, User user, List<Submission> children, Model model) {
        String display = POST;

        model.addAttribute("title", post.getTitle());
        model.addAttribute("description", post.getBody());
        model.addAttribute("user", user.getUserName());
        model.addAttribute("children", children);
        return display;
    }

    /**
     * Displays the 404 page. Used when an invalid submission or endpoint is requested.
     *
     * @return
     */
    public String display404() {
        return NOT_FOUND_404;
    }
}
