
package aiss.GitHubMiner.model2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "project_id",
    "title",
    "description",
    "state",
    "created_at",
    "updated_at",
    "closed_at",
    "labels",
    "upvotes",
    "downvotes",
    "user"
})
@Generated("jsonschema2pojo")
public class Issue {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("number")
    private Integer iid;
    @JsonProperty("title")
    private String title;
    @JsonProperty("user")
    private User author;
    @JsonProperty("labels")
    private List<Label> labels;
    @JsonProperty("state")
    private String state;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("closed_at")
    private Object closedAt;
    @JsonProperty("body")
    private String description;
    @JsonProperty("reactions")
    private Reactions reactions;

    @JsonProperty("comment")
    private List<Comment> comment;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("iid")
    public Integer getIid() {
        return iid;
    }

    @JsonProperty("iid")
    public void setIid(Integer iid) {
        this.iid = iid;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("closed_at")
    public Object getClosedAt() {
        return closedAt;
    }

    @JsonProperty("closed_at")
    public void setClosedAt(Object closedAt) {
        this.closedAt = closedAt;
    }

    @JsonProperty("labels")
    public List<String> getLabels() {
        List<String> lista = new ArrayList<>();
        for(Label x:labels){
            lista.add(x.getName());

        }
        return lista;
    }



    @JsonProperty("upvotes")
    public Integer getUpvotes() {
        return reactions.getUp();
    }

    @JsonProperty("upvotes")
    public void setUpvotes(Integer upvotes) {
        this.reactions.setUp(upvotes);
    }

    @JsonProperty("downvotes")
    public Integer getDownvotes() {
        return reactions.getDown();
    }

    @JsonProperty("downvotes")
    public void setDownvotes(Integer downvotes) {
        this.reactions.setDown(downvotes);
    }

    @JsonProperty("author")
    public User getUser() {
        return author;
    }

    @JsonProperty("author")
    public void setUser(User author) {
        this.author = author;
    }
    @JsonProperty("comment")
    public List<Comment> getComment() {
        return comment;
    }

    @JsonProperty("comment")
    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("ref_Id");
        sb.append('=');
        sb.append(((this.iid == null)?"<null>":this.iid));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("state");
        sb.append('=');
        sb.append(((this.state == null)?"<null>":this.state));
        sb.append(',');
        sb.append("createdAt");
        sb.append('=');
        sb.append(((this.createdAt == null)?"<null>":this.createdAt));
        sb.append(',');
        sb.append("updatedAt");
        sb.append('=');
        sb.append(((this.updatedAt == null)?"<null>":this.updatedAt));
        sb.append(',');
        sb.append("closedAt");
        sb.append('=');
        sb.append(((this.closedAt == null)?"<null>":this.closedAt));
        sb.append(',');
        sb.append("labels");
        sb.append('=');
        sb.append(((this.labels == null)?"<null>":this.labels));
        sb.append(',');
        sb.append("upvotes");
        sb.append('=');
        sb.append(((this.reactions.getUp() == null)?"<null>":this.reactions.getUp()));
        sb.append(',');
        sb.append("downvotes");
        sb.append('=');
        sb.append(((this.reactions.getDown() == null)?"<null>":this.reactions.getDown()));
        sb.append(',');
        sb.append("User");
        sb.append(':');
        sb.append(((this.author == null)?"<null>":this.author));
        sb.append(',');
        sb.append("Comment");
        sb.append(':');
        sb.append(((this.comment == null)?"<null>":this.comment));
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), '}');
        } else {
            sb.append('}');
        }
        return sb.toString();
    }

}
