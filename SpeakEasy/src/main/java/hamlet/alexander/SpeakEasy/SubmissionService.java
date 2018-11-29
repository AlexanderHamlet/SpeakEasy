package hamlet.alexander.SpeakEasy;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Submission DATA ACCESS OBJECT service layer.
 *
 * Object that interacts with
 * submission data coming in and out of the
 * SUBMISSION Collection in the Mongo Database.
 *
 * Applys minimal business logic to ensure
 * correct formatting.
 */
@Service
public class SubmissionService {

    /**
     * MongoRepository for submission data.
     */
    @Autowired
    private SubmissionRepository submissionRepository;

    private static final String ORIGINAL = " ";
    private static final String ENCODED_DELIMETER = "_";

    /**
     * Grabs forum data by using a title for the search query.
     * Insures spaces are converted to underscores for query.
     *
     * @param title
     * @return
     */
    public Forum findByForumTitle(String title) {
        return submissionRepository.findByForumTitle(title.replace(ORIGINAL, ENCODED_DELIMETER));
    }

    /**
     * Grabs post data by using a title for the search query.
     * Insures spaces are converted to underscores for query.
     *
     * @param title
     * @return
     */
    public Post findByPostTitle(String title) {
        return submissionRepository.findByPostTitle(title.replace(ORIGINAL, ENCODED_DELIMETER));
    }

    /**
     * MAIN REASON FOR USING PARENT IDs INSTEAD OF CHILDREN IDs.
     * THIS SIMPLIFIES BUSINESS LOGIC.
     *
     * Grabs all submissions that have the specified id as their
     * parent id.
     *
     * @param parentId
     * @return
     */
    public List<Submission> findByParentId(ObjectId parentId) {
        return submissionRepository.findByParentId(parentId);
    }

    /**
     * Grabs all submissions that have the specified id as their
     * poster id.
     *
     * @param posterId
     * @return
     */
    public List<Submission> findByPosterId(ObjectId posterId) {
        return submissionRepository.findByPosterId(posterId);
    }

    /**
     * Grabs a single submission by using an id as the query.
     *
     * @param id
     * @return
     */
    public Submission findById(ObjectId id) {
        return submissionRepository.findById(id);
    }

    /**
     * Stores a submission into the database.
     * Insures spaces are converted to underscores for simplicity.
     *
     * @param submission
     */
    public void save(Submission submission) {
        submission.setTitle(submission.getTitle().replace(ORIGINAL, ENCODED_DELIMETER));
        submissionRepository.save(submission);
    }

    /**
     * Deletes a specified submission by that submission's id.
     *
     * @param id
     */
    public void delete(ObjectId id) {
        submissionRepository.delete(submissionRepository.findById(id));
    }
}
