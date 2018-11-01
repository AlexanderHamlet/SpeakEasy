package hamlet.alexander.SpeakEasy.Submission;

public class Post extends Submission {

    private String title;
    private String body;

    public Post(String title, String body) {
        super();
        this.title = title;
        this.body = body;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
