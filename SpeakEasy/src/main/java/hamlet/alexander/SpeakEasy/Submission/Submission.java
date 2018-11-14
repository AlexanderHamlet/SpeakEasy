package hamlet.alexander.SpeakEasy.Submission;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "submission")
public abstract class Submission {

    @Id
    private int id;

    private int parentId;
    private int posterId;
    private List<Integer> childrenIds;

    Submission(int parentId, int posterId) {
        this.parentId = parentId;
        this.posterId = posterId;
        this.childrenIds = new ArrayList<Integer>();
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

    public List<Integer> getChildren() {
        return childrenIds;
    }

    public void addChild(int child) {
        this.childrenIds.add(child);
    }

    public abstract String getTitle();
    public abstract String getBody();
}
