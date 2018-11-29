package hamlet.alexander.SpeakEasy;

import org.springframework.stereotype.Component;

/**
 * MODEL VIEW CONTROLLER DESIGN PATTERN: Model
 *
 * The Session object is the central component of
 * SpeakEasy's functionality. This is what stores
 * all the current data for a user's session on the
 * website. Without this class, SpeakEasy could not
 * run.
 *
 * It holds the current user data and the current
 * submission being viewed by the user.
 */
@Component
public class Session {

    private User user;
    private Submission submission;

    /**
     * Constructor.
     * Initializes the user to be an anonymous user who is not logged in.
     * This user can view the site and it's contents, but cannot post
     * or delete submissions.
     *
     * The current submission is set by the routing in the SessionController.
     */
    public Session() {
        this.user = new User("Anon", "","logged-out");
    }

    /**
     * Grabs the current user.
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the current user.
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Grabs the current submission.
     *
     * @return
     */
    public Submission getSubmission() {
        return submission;
    }

    /**
     * Sets the current submission.
     *
     * @param submission
     */
    public void setSubmission(Submission submission) {
        this.submission = submission;
    }
}
