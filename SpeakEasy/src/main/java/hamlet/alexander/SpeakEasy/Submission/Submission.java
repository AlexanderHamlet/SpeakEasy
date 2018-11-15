package hamlet.alexander.SpeakEasy.Submission;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "submission")
public abstract class Submission {

    @Id
    private ObjectId id;

    private ObjectId parentId;
    private ObjectId posterId;

    Submission(ObjectId parentId, ObjectId posterId) {
        this.parentId = parentId;
        this.posterId = posterId;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getParentId() {
        return parentId;
    }

    public ObjectId getPosterId() {
        return posterId;
    }

    public abstract String getTitle();
    public abstract String getBody();
}
