package hamlet.alexander.SpeakEasy.Submission;

import org.bson.types.ObjectId;

public class Forum extends Discussion {

    private ObjectId moderatorId;
    private String forumTitle;
    private String description;

    public Forum(ObjectId parentId, ObjectId moderatorId, String forumTitle, String description) {
        super(parentId, moderatorId);
        this.moderatorId = moderatorId;
        this.forumTitle = forumTitle;
        this.description = description;
    }

    public ObjectId getModeratorId() {
        return moderatorId;
    }

    public void setModeratorId(ObjectId moderatorId) {
        this.moderatorId = moderatorId;
    }

    @Override
    public String getTitle() {
        return forumTitle;
    }

    public void setTitle(String title) {
        this.forumTitle = title;
    }

    @Override
    public String getBody() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
