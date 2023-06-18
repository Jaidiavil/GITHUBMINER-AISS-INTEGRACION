
package aiss.GitHubMiner.model2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "title",
    "message",
    "author_name",
    "author_email",
    "authored_date",
    "committer_name",
    "committer_email",
    "committed_date",
    "web_url"
})
@Generated("jsonschema2pojo")
public class Commit {

    @JsonProperty("sha")
    private String id;
    @JsonProperty("node_id")
    private String title;
    @JsonProperty("commit")
    private Commit__1 commit;

    @JsonProperty("url")
    private String webUrl;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("message")
    public String getMessage() {
        return commit.getMessage();
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.commit.setMessage(message);
    }

    @JsonProperty("author_name")
    public String getAuthorName() {
        return this.commit.getAuthor().getName();
    }

    @JsonProperty("author_name")
    public void setAuthorName(String authorName) {
        this.commit.getAuthor().setName(authorName);
    }

    @JsonProperty("author_email")
    public String getAuthorEmail() {
        return this.commit.getAuthor().getEmail();
    }

    @JsonProperty("author_email")
    public void setAuthorEmail(String authorEmail) {
        this.commit.getAuthor().setEmail(authorEmail);
    }

    @JsonProperty("authored_date")
    public String getAuthoredDate() {
        return this.commit.getAuthor().getDate();
    }

    @JsonProperty("authored_date")
    public void setAuthoredDate(String authoredDate) {
        this.commit.getAuthor().setDate(authoredDate);
    }

    @JsonProperty("committer_name")
    public String getCommitterName() {
        return this.commit.getCommitter().getName();
    }

    @JsonProperty("committer_name")
    public void setCommitterName(String committerName) {
        this.commit.getCommitter().setName(committerName);
    }

    @JsonProperty("committer_email")
    public String getCommitterEmail() {
        return this.commit.getCommitter().getEmail();
    }

    @JsonProperty("committer_email")
    public void setCommitterEmail(String committerEmail) {
        this.commit.getCommitter().setEmail(committerEmail);
    }

    @JsonProperty("committed_date")
    public String getCommittedDate() {
        return this.commit.getCommitter().getDate();
    }

    @JsonProperty("committed_date")
    public void setCommittedDate(String committedDate) {
        this.commit.getCommitter().setDate(committedDate);
    }

    @JsonProperty("web_url")
    public String getWebUrl() {
        return webUrl;
    }

    @JsonProperty("web_url")
    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("message");
        sb.append('=');
        sb.append(((this.commit.getMessage() == null)?"<null>":this.commit.getMessage()));
        sb.append(',');
        sb.append("authorName");
        sb.append('=');
        sb.append(((this.commit.getAuthor().getName() == null)?"<null>":this.commit.getAuthor().getName()));
        sb.append(',');
        sb.append("authorEmail");
        sb.append('=');
        sb.append(((this.commit.getAuthor().getEmail() == null)?"<null>":this.commit.getAuthor().getEmail()));
        sb.append(',');
        sb.append("authoredDate");
        sb.append('=');
        sb.append(((this.commit.getAuthor().getDate() == null)?"<null>":this.commit.getAuthor().getDate()));
        sb.append(',');
        sb.append("committerName");
        sb.append('=');
        sb.append(((this.commit.getCommitter().getName() == null)?"<null>":this.commit.getCommitter().getName()));
        sb.append(',');
        sb.append("committerEmail");
        sb.append('=');
        sb.append(((this.commit.getCommitter().getEmail() == null)?"<null>":this.commit.getCommitter().getEmail()));
        sb.append(',');
        sb.append("committedDate");
        sb.append('=');
        sb.append(((this.commit.getCommitter().getDate() == null)?"<null>":this.commit.getCommitter().getDate()));
        sb.append(',');
        sb.append("webUrl");
        sb.append('=');
        sb.append(((this.webUrl == null)?"<null>":this.webUrl));
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), '}');
        } else {
            sb.append('}');
        }
        return sb.toString();
    }

}
