package hamlet.alexander.SpeakEasy.Submission;

public class Forum extends Submission {

    private int moderatorId;
    private String title;
    private String description;

    public Forum(int moderatorId, String title, String description) {
        super(0, moderatorId);
        this.moderatorId = moderatorId;
        this.title = title;
        this.description = description;
    }

    public int getModeratorId() {
        return moderatorId;
    }

    public void setModeratorId(int moderatorId) {
        this.moderatorId = moderatorId;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getBody() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
