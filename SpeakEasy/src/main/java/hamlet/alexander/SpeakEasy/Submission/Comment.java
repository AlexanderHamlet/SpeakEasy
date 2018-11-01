package hamlet.alexander.SpeakEasy.Submission;

public class Comment extends Submission {

    private String body;

    public Comment(String body) {
        super();
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String getTitle() {
        return "";
    }
}
