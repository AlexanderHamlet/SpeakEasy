package hamlet.alexander.SpeakEasy.Submission;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SubmissionRepository extends MongoRepository<Submission, Integer> {

    Forum findByForumTitle(String title);
    Post findByPostTitle(String title);
    Submission findById(ObjectId id);

    List<Submission> findByParentId(ObjectId parentId);
    List<Submission> findByPosterId(ObjectId posterId);

    void removeById(ObjectId id);
}
