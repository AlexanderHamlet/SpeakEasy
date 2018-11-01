package hamlet.alexander.SpeakEasy.User;

import java.util.ArrayList;
import java.util.List;

import hamlet.alexander.SpeakEasy.Submission.Submission;

import org.springframework.stereotype.Component;

@Component
public class User {

    private int id;
    private String userName;
    private String role;
    private List<Submission> submissions;

    public User() {
        this.id = -1;
        this.userName = "User";
        this.role = "logged-out";
        this.submissions = new ArrayList<Submission>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }
}
