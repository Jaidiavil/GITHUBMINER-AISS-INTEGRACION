package aiss.GitHubMiner.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "author",
        "committer",
        "message",
        "tree",
        "url",
        "comment_count"
})
@Generated("jsonschema2pojo")
public class CommitData {

    @JsonProperty("author")
    private Author author;
    @JsonProperty("committer")
    private Committer committer;
    @JsonProperty("message")
    private String message;
    @JsonProperty("tree")
    private Tree tree;
    @JsonProperty("url")
    private String url;
    @JsonProperty("comment_count")
    private Integer commentCount;

    @JsonProperty("author")
    public Author getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(Author author) {
        this.author = author;
    }

    @JsonProperty("committer")
    public Committer getCommitter() {
        return committer;
    }

    @JsonProperty("committer")
    public void setCommitter(Committer committer) {
        this.committer = committer;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("tree")
    public Tree getTree() {
        return tree;
    }

    @JsonProperty("tree")
    public void setTree(Tree tree) {
        this.tree = tree;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("comment_count")
    public Integer getCommentCount() {
        return commentCount;
    }

    @JsonProperty("comment_count")
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CommitData.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("author");
        sb.append('=');
        sb.append(((this.author == null)?"<null>":this.author));
        sb.append(',');
        sb.append("committer");
        sb.append('=');
        sb.append(((this.committer == null)?"<null>":this.committer));
        sb.append(',');
        sb.append("message");
        sb.append('=');
        sb.append(((this.message == null)?"<null>":this.message));
        sb.append(',');
        sb.append("tree");
        sb.append('=');
        sb.append(((this.tree == null)?"<null>":this.tree));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("commentCount");
        sb.append('=');
        sb.append(((this.commentCount == null)?"<null>":this.commentCount));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
