package hamlet.alexander.SpeakEasy.Submission;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Comment implements Submission {

    @Id
    private ObjectId id;

    private ObjectId parentId;
    private ObjectId posterId;
    private String body;

    public Comment(ObjectId parentId, ObjectId posterId, String body) {
        this.body = body;
    }

    public ObjectId getId() {
        return this.id;
    }

    public ObjectId getParentId() {
        return this.parentId;
    }

    public ObjectId getPosterId() {
        return this.posterId;
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

    public void setTitle(String title) {}

}
