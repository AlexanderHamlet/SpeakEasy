package hamlet.alexander.SpeakEasy.Submission;

import hamlet.alexander.SpeakEasy.Submission.SubmissionRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionService {

    @Autowired
    private SubmissionRepository submissionRepository;

    public Forum findByForumTitle(String title) {
        title = title.replace(" ", "_");
        return submissionRepository.findByForumTitle(title);
    }

    public Post findByPostTitle(String title) {
        title = title.replace(" ", "_");
        return submissionRepository.findByPostTitle(title);
    }

    public List<Submission> findByParentId(ObjectId parentId) {
        return submissionRepository.findByParentId(parentId);
    }

    public List<Submission> findByPosterId(ObjectId posterId) {
        return submissionRepository.findByPosterId(posterId);
    }

    public Submission findById(ObjectId id) {
        return submissionRepository.findById(id);
    }

    public void save(Submission submission) {
        String title = submission.getTitle();
        title = title.replace(" ", "_");
        submission.setTitle(title);
        submissionRepository.save(submission);
    }
}
