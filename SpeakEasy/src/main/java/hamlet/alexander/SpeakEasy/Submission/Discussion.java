package hamlet.alexander.SpeakEasy.Submission;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public abstract class Discussion implements Submission {

    @Id
    private ObjectId id;

    private ObjectId parentId;
    private ObjectId posterId;

    Discussion(ObjectId parentId, ObjectId posterId) {
        this.parentId = parentId;
        this.posterId = posterId;
    }

    public ObjectId getId() {
        return id;
    }

    public ObjectId getParentId() {
        return parentId;
    }

    public ObjectId getPosterId() {
        return posterId;
    }
}
