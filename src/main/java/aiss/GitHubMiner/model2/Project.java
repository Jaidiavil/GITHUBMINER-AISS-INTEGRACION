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
        "name",
        "web_url"
})
@Generated("jsonschema2pojo")
public class Project {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String webUrl;
    @JsonProperty("commits")
    private List<Commit> commits;
    @JsonProperty("issues")
    private List<Issue> issues;

    public Project(Project proyecto) {
        this.id = proyecto.getId();
        this.name = proyecto.getName();
        this.webUrl = proyecto.getWebUrl();
        this.commits = new ArrayList<>();
        this.issues = new ArrayList<>();
    }
    public Project(Integer id, String name, String WebUrl) {
        this.id = id;
        this.name = name;
        this.webUrl = webUrl;
        this.commits = new ArrayList<>();
        this.issues = new ArrayList<>();
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("web_url")
    public String getWebUrl() {
        return webUrl;
    }

    @JsonProperty("web_url")
    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }
    @JsonProperty("commit")
    public List<Commit> getCommit() {
        return commits;
    }

    @JsonProperty("commit")
    public void setCommit(List<Commit> commit) {
        this.commits = commit;
    }
    @JsonProperty("issues")
    public List<Issue> getIssues() {
        return issues;
    }

    @JsonProperty("issues")
    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("webUrl");
        sb.append('=');
        sb.append(((this.webUrl == null)?"<null>":this.webUrl));
        sb.append(", " );
        sb.append("Commits");
        sb.append(':');
        sb.append(((this.commits == null)?"<null>":this.commits));
        sb.append(", " );
        sb.append("Issues");
        sb.append(':');
        sb.append(((this.issues == null)?"<null>":this.issues));

        return sb.toString();
    }

}
