package hamlet.alexander.SpeakEasy.Submission;

import org.bson.types.ObjectId;

public class Comment extends Submission {

    private String body;

    public Comment(ObjectId parentId, ObjectId posterId, String body) {
        super(parentId, posterId);
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
