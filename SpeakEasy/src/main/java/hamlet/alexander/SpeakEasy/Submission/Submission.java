package hamlet.alexander.SpeakEasy.Submission;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "submission")
public interface Submission {

    ObjectId getId();

    ObjectId getParentId();

    ObjectId getPosterId();

    String getTitle();
    void setTitle(String title);
    String getBody();
}
