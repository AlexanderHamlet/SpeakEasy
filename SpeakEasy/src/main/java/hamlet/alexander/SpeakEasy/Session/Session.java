package hamlet.alexander.SpeakEasy.Session;

import hamlet.alexander.SpeakEasy.Menu.Menu;
import hamlet.alexander.SpeakEasy.Submission.Forum;
import hamlet.alexander.SpeakEasy.Submission.Submission;
import hamlet.alexander.SpeakEasy.User.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Session {

    private User user;
    private Submission submission;

    @Autowired
    private Menu menu;

    public Session() {
        this.user = new User("Anon", "logged-out");
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Submission getSubmission() {
        return submission;
    }

    public void setSubmission(Submission submission) {
        this.submission = submission;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
