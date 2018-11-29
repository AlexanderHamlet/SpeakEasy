package hamlet.alexander.SpeakEasy;

import org.bson.types.ObjectId;

/**
 * COMPOSITE DESIGN PATTERN: Composite piece.
 *
 * Posts are the center of discussions on Forums.
 * Each post belongs to a specified forum and should
 * be related to that forum's topic.
 *
 * To create a post, go to the "Add to the conversation!"
 * section in the desired forum and submit a title
 * and a text body.
 *
 * The original poster, the forum moderator,
 * and the site admins have the privilege to
 * delete a post. To delete a post, go to "Delete
 * Post" section in the forum the post is in and
 * submit the title of the post.
 *
 * Posts can only be children of forums that are not
 * the Frontpage, and only have comments as children.
 *
 */
public class Post extends Discussion {

    private String postTitle;
    private String body;

    /**
     * Constructor.
     * Initializes parent's Id, poster's Id, the post's title, and the post's body.
     *
     * @param parentId
     * @param posterId
     * @param postTitle
     * @param body
     */
    public Post(ObjectId parentId, ObjectId posterId, String postTitle, String body) {
        super(parentId, posterId);
        this.postTitle = postTitle;
        this.body = body;
    }

    /**
     * Grabs the post title.
     *
     * @return
     */
    public String getTitle() {
        return postTitle;
    }

    /**
     * Sets the post title.
     *
     * @param title
     */
    public void setTitle(String title) {
        this.postTitle = title;
    }

    /**
     * Grabs the post's body text.
     *
     * @return
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the post's body text.
     *
     * @param body
     */
    public void setBody(String body) {
        this.body = body;
    }
}
