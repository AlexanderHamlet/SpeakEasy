package hamlet.alexander.SpeakEasy;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * COMPOSITE DESIGN PATTERN: Leaf Node.
 *
 * Holds text bodies for comments on posts. These
 * are the submissions comprising the bulk of the
 * discussions here on SpeakEasy.
 *
 * A comment can only be a child of a post. This
 * is insured by the submit method in the
 * SessionController class where submissions made
 * on a post page are automatically created as
 * comments, and only post pages can create
 * comments.
 *
 * The Comment class is the leaf node in the
 * composite tree structure. This means it will have
 * no children.
 *
 * Note: You may notice that this class has all the
 *       same properties as the composite pieces of
 *       this design. This is because I'm using the
 *       MongoDB way of saving and accessing the
 *       data.
 *
 *       If it extended the Discussion class, it
 *       would work in the exact same way as it
 *       does now. This does mean it is technically
 *       possible for a Comment to have children.
 *       It would just take a Submission object to
 *       place a Comment Id as its parent Id.
 *
 *       The reason I kept it separate was to
 *       emphasize that this is a leaf node and
 *       should have no children.
 *
 *       I've enforced this by insuring that it is
 *       not possible to set a Comment's Id as a
 *       parent Id for any object. To see how, go
 *       to the submit method in
 *       SessionController.java and also see
 *       SessionView.java.
 *
 */
public class Comment implements Submission {

    @Id
    private ObjectId id;

    private ObjectId parentId;
    private ObjectId posterId;
    private String body;

    /**
     * Constructor.
     * Initializes parent's Id, poster's Id, and the text body.
     *
     * @param parentId
     * @param posterId
     * @param body
     */
    public Comment(ObjectId parentId, ObjectId posterId, String body) {
        this.parentId = parentId;
        this.posterId = posterId;
        this.body = body;
    }

    /**
     * Grabs the comment's Id.
     *
     * @return
     */
    public ObjectId getId() {
        return this.id;
    }

    /**
     * Grabs the parent submission's Id.
     *
     * @return
     */
    public ObjectId getParentId() {
        return this.parentId;
    }

    /**
     * Grabs the poster's Id.
     *
     * @return
     */
    public ObjectId getPosterId() {
        return this.posterId;
    }

    /**
     * Grabs the text body.
     * This is the main information of a Comment object.
     *
     * @return
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the text body.
     * This is the main information of a Comment object.
     *
     * @param body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Comments do not have Titles.
     * This method is necessary for Submission objects,
     * and therefore, returns an empty string.
     *
     * @return
     */
    public String getTitle() {
        return "";
    }

    /**
     * Comments do not have Titles.
     * This method is necessary for Submission objects,
     * and therefore, does absolutely nothing for Comments.
     *
     * @param title
     */
    public void setTitle(String title) {}

}
