package hamlet.alexander.SpeakEasy;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * COMPOSITE DESIGN PATTERN : Main Component
 *
 * The Submission interface is the primary component of the
 * composite design pattern. Defined here are all the necessary
 * methods that need to be implemented for the
 * tree structure to work.
 *
 * Due to MongoDB's specified syntax to access object data
 * from its collections, this composite design has each piece
 * keep track of its parent Id instead of keeping track of its
 * children's Ids. This simplifies the logic to store and
 * access children from the database.
 *
 * Composite Abstract: Discussion.java
 * Composites: Forum.java, Post.java
 * Leaf: Comment.java
 */
@Document(collection = "submission")
public interface Submission {

    /**
     * Gets the Id of the object.
     *
     * @return
     */
    ObjectId getId();

    /**
     * Gets the object's parent's Id.
     *
     * @return
     */
    ObjectId getParentId();

    /**
     * Gets the Id of the user who posted the submission.
     *
     * @return
     */
    ObjectId getPosterId();

    /**
     * Gets the Title of the submission.
     *
     * @return
     */
    String getTitle();

    /**
     * Sets the Title of the submission.
     *
     * @param title
     */
    void setTitle(String title);

    /**
     * Gets the text Body of the submission.
     * @return
     */
    String getBody();
}
