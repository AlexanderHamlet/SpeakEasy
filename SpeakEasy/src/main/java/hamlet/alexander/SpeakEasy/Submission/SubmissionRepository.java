package hamlet.alexander.SpeakEasy.Submission;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SubmissionRepository extends MongoRepository<Submission, Integer> {

    public Forum findByForumTitle(String title);
    public Post findByPostTitle(String title);
    public Submission findById(ObjectId id);

    public List<Submission> findByParentId(ObjectId parentId);
    public List<Submission> findByPosterId(ObjectId posterId);
}
