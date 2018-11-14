package hamlet.alexander.SpeakEasy.Submission;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SubmissionRepository extends MongoRepository<Submission, Integer> {

    public Forum findByTitle(String title);
    public Submission findById(int id);

    public List<Submission> findByParentId(int parentId);
    public List<Submission> findByPosterId(int posterId);
}
