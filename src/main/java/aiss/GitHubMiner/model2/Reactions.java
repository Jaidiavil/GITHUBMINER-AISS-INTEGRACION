package aiss.GitHubMiner.model2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Reactions {


    @JsonProperty("+1")
    private Integer upvotes;
    @JsonProperty("-1")
    private Integer downvotes;

    @JsonProperty("up")
    public Integer getUp() {
        return upvotes;
    }

    @JsonProperty("up")
    public void setUp(Integer up) {
        this.upvotes = up;
    }

    @JsonProperty("down")
    public Integer getDown() {
        return downvotes;
    }

    @JsonProperty("down")
    public void setDown(Integer down) {
        this.downvotes = down;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Reactions.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("up");
        sb.append('=');
        sb.append(((this.upvotes == null)?"<null>":this.upvotes));
        sb.append(',');
        sb.append("down");
        sb.append('=');
        sb.append(((this.downvotes == null)?"<null>":this.downvotes));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}
