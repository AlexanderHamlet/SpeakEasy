package hamlet.alexander.SpeakEasy.Submission;

import java.util.ArrayList;
import java.util.List;

public abstract class Submission {

    private int id;
    private int parentId;
    private int posterId;
    private List<Submission> childrenIds;

    Submission() {
        this.id = -1;
        this.parentId = -1;
        this.posterId = -1;
        this.childrenIds = new ArrayList<Submission>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public int getPosterId() {
        return posterId;
    }

    public List<Submission> getChildren() {
        return childrenIds;
    }

    public void addChild(Submission child) {
        this.childrenIds.add(child);
    }

    public abstract String getTitle();
    public abstract String getBody();
}
