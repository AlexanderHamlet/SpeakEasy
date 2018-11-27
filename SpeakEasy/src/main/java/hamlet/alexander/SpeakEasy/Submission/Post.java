package hamlet.alexander.SpeakEasy.Submission;

import org.bson.types.ObjectId;

public class Post extends Discussion {

    private String postTitle;
    private String body;

    public Post(ObjectId parentId, ObjectId posterId, String postTitle, String body) {
        super(parentId, posterId);
        this.postTitle = postTitle;
        this.body = body;
    }

    @Override
    public String getTitle() {
        return postTitle;
    }

    public void setTitle(String title) {
        this.postTitle = title;
    }

    @Override
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
