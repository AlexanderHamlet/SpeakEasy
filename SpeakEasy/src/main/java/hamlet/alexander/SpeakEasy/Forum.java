package hamlet.alexander.SpeakEasy;

import org.bson.types.ObjectId;

/**
 * COMPOSITE DESIGN PATTER: Composite piece.
 *
 * Forums are the locations where discussion start
 * on SpeakEasy. Each forum is dedicated to
 * discussions around a specific topic and these
 * discussions are monitored by a special user
 * known as a moderator. The user who created the forum
 * becomes the moderator and has special privilages to
 * delete posts that are off topic. Site admins also
 * have privilages to delete posts.
 *
 * There is a special forum known as the Frontpage. This
 * is the homepage of the site, and the location where
 * users can create forums. To create a forum, input a
 * title and a description of the forum in the "Add to
 * the conversation!" section. The Frontpage stores all
 * the forums on the site as children in composite design
 * pattern tree.
 *
 * Each forum holds posts as its children in the
 * composite design pattern and calls the frontpage
 * parent.
 *
 * Only site admins and moderators have the privilage to
 * delete forums. To do this, go to the frontpage and submit
 * the title of the desired forum to delete in the "Delete
 * Forum" Section.
 */
public class Forum extends Discussion {

    private ObjectId moderatorId;
    private String forumTitle;
    private String description;

    /**
     * Constructor.
     * Initializes parent's Id, moderator's Id, title, and description.
     *
     * @param parentId
     * @param moderatorId
     * @param forumTitle
     * @param description
     */
    public Forum(ObjectId parentId, ObjectId moderatorId, String forumTitle, String description) {
        super(parentId, moderatorId);
        this.moderatorId = moderatorId;
        this.forumTitle = forumTitle;
        this.description = description;
    }

    /**
     * Grabs the moderator's Id.
     *
     * @return
     */
    public ObjectId getModeratorId() {
        return moderatorId;
    }

    /**
     * Sets the moderator's Id.
     *
     * @param moderatorId
     */
    public void setModeratorId(ObjectId moderatorId) {
        this.moderatorId = moderatorId;
    }

    /**
     * Grabs the title.
     *
     * @return
     */
    @Override
    public String getTitle() {
        return forumTitle;
    }

    /**
     * Sets the title.
     *
     * @param title
     */
    @Override
    public void setTitle(String title) {
        this.forumTitle = title;
    }

    /**
     * Grabs the description.
     *
     * @return
     */
    @Override
    public String getBody() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
