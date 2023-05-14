package aiss.GitHubMiner.service;

import aiss.GitHubMiner.post.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    RestTemplate template;
    final String baseUri = "https://api.gitgub.com/";

    public List<Comment> getNotes(String owner, String repoName, String iid) {
        String uri = baseUri + "/repos/" + owner + "/" + repoName +  "/issues/" + iid + "/comments";
    }
}
