package aiss.GitHubMiner.model2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Label {
    @JsonProperty("name")
    private String name;

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }
}
