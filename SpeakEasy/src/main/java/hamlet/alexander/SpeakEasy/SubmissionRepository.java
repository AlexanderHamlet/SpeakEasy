package hamlet.alexander.SpeakEasy;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * MongoRepository for submission data. Only object to directly
 * interact with submission collection in MongoDB.
 */
public interface SubmissionRepository extends MongoRepository<Submission, Integer> {

    Forum findByForumTitle(String title);
    Post findByPostTitle(String title);
    Submission findById(ObjectId id);

    List<Submission> findByParentId(ObjectId parentId);
    List<Submission> findByPosterId(ObjectId posterId);

    void removeById(ObjectId id);
}
