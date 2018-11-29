package hamlet.alexander.SpeakEasy;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * COMPOSITE DESIGN PATTER: Abstract Composite.
 *
 * The Discussion class is the abstract composite piece
 * of this design. Any class the extends this one will
 * be a composite piece of the tree structure indicating
 * they will/could have children.
 *
 * Here you will find base pieces of data and logic that
 * all composites have to implement. They're abstracted
 * here for simplicity.
 *
 * Composites extending this class: Forum.java, Post.java
 */
public abstract class Discussion implements Submission {

    @Id
    private ObjectId id;

    private ObjectId parentId;
    private ObjectId posterId;

    /**
     * Constructor.
     * Initializes the parent submission and poster Ids.
     *
     * @param parentId
     * @param posterId
     */
    Discussion(ObjectId parentId, ObjectId posterId) {
        this.parentId = parentId;
        this.posterId = posterId;
    }

    /**
     * Grabs the object's Id.
     *
     * @return
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Grabs the parent submission's Id.
     *
     * @return
     */
    public ObjectId getParentId() {
        return parentId;
    }

    /**
     * Grabs the poster's Id.
     *
     * @return
     */
    public ObjectId getPosterId() {
        return posterId;
    }
}
