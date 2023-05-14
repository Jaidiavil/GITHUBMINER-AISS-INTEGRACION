package aiss.GitHubMiner.post;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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

    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("message")
    private String message;
    @JsonProperty("author_name")
    private String author_name;
    @JsonProperty("author_email")
    private String author_email;
    @JsonProperty("authored_date")
    private String authored_date;
    @JsonProperty("committer_name")
    private String committer_name;
    @JsonProperty("committer_email")
    private String committer_email;
    @JsonProperty("committed_date")
    private String committed_date;
    @JsonProperty("committer_email")
    private String web_url;

    public Commit(String id, String title, String message, String author_name, String author_email, String authored_date, String committer_name, String committer_email, String committed_date, String web_url) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.author_name = author_name;
        this.author_email = author_email;
        this.authored_date = authored_date;
        this.committer_name = committer_name;
        this.committer_email = committer_email;
        this.committed_date = committed_date;
        this.web_url = web_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_email() {
        return author_email;
    }

    public void setAuthor_email(String author_email) {
        this.author_email = author_email;
    }

    public String getAuthored_date() {
        return authored_date;
    }

    public void setAuthored_date(String authored_date) {
        this.authored_date = authored_date;
    }

    public String getCommitter_name() {
        return committer_name;
    }

    public void setCommitter_name(String committer_name) {
        this.committer_name = committer_name;
    }

    public String getCommitter_email() {
        return committer_email;
    }

    public void setCommitter_email(String committer_email) {
        this.committer_email = committer_email;
    }

    public String getCommitted_date() {
        return committed_date;
    }

    public void setCommitted_date(String committed_date) {
        this.committed_date = committed_date;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(User.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        sb.append(((this.message == null)?"<null>":this.message));
        sb.append(',');
        sb.append("author_name");
        sb.append('=');
        sb.append(((this.author_name == null)?"<null>":this.author_name));
        sb.append(',');
        sb.append("author_email");
        sb.append('=');
        sb.append(((this.author_email == null)?"<null>":this.author_email));
        sb.append(',');
        sb.append("authored_date");
        sb.append('=');
        sb.append(((this.authored_date == null)?"<null>":this.authored_date));
        sb.append(',');
        sb.append("committer_name");
        sb.append('=');
        sb.append(((this.committer_name == null)?"<null>":this.committer_name));
        sb.append(',');
        sb.append("committer_email");
        sb.append('=');
        sb.append(((this.committer_email == null)?"<null>":this.committer_email));
        sb.append(',');
        sb.append("committed_date");
        sb.append('=');
        sb.append(((this.committed_date == null)?"<null>":this.committed_date));
        sb.append(',');
        sb.append("web_url");
        sb.append('=');
        sb.append(((this.web_url == null)?"<null>":this.web_url));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}