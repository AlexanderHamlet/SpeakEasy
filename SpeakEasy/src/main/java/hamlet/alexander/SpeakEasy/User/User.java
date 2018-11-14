package hamlet.alexander.SpeakEasy.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {

    @Id
    private int id;

    private String userName;
    private String role;
    private List<Integer> submissions;

    public User(String userName, String role) {
        this.userName = userName;
        this.role = role;
        this.submissions = new ArrayList<Integer>();
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

    public List<Integer> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Integer> submissions) {
        this.submissions = submissions;
    }
}
