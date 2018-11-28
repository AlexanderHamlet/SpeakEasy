package hamlet.alexander.SpeakEasy.Submission;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionService {

    @Autowired
    private SubmissionRepository submissionRepository;

    private static final String ORIGINAL = " ";
    private static final String ENCODED_DELIMETER = "_";

    public Forum findByForumTitle(String title) {
        Forum forum = submissionRepository.findByForumTitle(title.replace(ORIGINAL, ENCODED_DELIMETER));
        return forum;
    }

    public Post findByPostTitle(String title) {
        Post post = submissionRepository.findByPostTitle(title.replace(ORIGINAL, ENCODED_DELIMETER));
        return post;
    }

    public List<Submission> findByParentId(ObjectId parentId) {
        List<Submission> children = submissionRepository.findByParentId(parentId);

        return children;
    }

    public List<Submission> findByPosterId(ObjectId posterId) {
        List<Submission> children = submissionRepository.findByPosterId(posterId);

        return children;
    }

    public Submission findById(ObjectId id) {
        Submission submission = submissionRepository.findById(id);
        return submission;
    }

    public void save(Submission submission) {
        submission.setTitle(submission.getTitle().replace(ORIGINAL, ENCODED_DELIMETER));
        submissionRepository.save(submission);
    }

    public void delete(ObjectId id) {
        submissionRepository.delete(submissionRepository.findById(id));
    }
}
