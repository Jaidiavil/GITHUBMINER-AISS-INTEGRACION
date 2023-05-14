package aiss.GitHubMiner.service;

import aiss.GitHubMiner.model.IssueGitHub;
import aiss.GitHubMiner.model.ProjectGitHub;
import aiss.GitHubMiner.post.Commit;
import aiss.GitHubMiner.post.Issue;
import aiss.GitHubMiner.post.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import aiss.GitHubMiner.model.CommitGitHub;

import java.util.Arrays;
import java.util.List;

@Service
public class GitHubService {
    @Autowired
    RestTemplate restTemplate;
    @Value("${github-miner.token}")
    private String token;

    private static Logger logger = LoggerFactory.getLogger(GitHubService.class);
    String baseUri = "https://api.github.com/repos/";

    public Project findProject() {
        HttpHeaders h = new HttpHeaders();
        h.setContentType(MediaType.APPLICATION_JSON);
        String uri = baseUri + "/";
        HttpEntity<Object> r = new HttpEntity<>(h);
        ResponseEntity<Project> res = restTemplate.exchange(uri, HttpMethod.GET, r, Project.class);
        return res.getBody();
    }
    public List<CommitGitHub> findAllCommitsProject(String owner, String repository) {
        CommitGitHub[] commits = restTemplate.
                getForObject(baseUri + owner + "/" + repository + "/commits", CommitGitHub[].class);
        return Arrays.
                stream(commits).
                toList();
    }

    public Project findGitMinerProject(String owner, String repo, int sinceCommits, int sinceIssues, int maxPages) {
        Project project = new Project(findProject());
        Project project1 = new Project(project.getId(), project.getName(), project.getWebUrl());
        return project1;
    }

    public ResponseEntity<CommitGitHub[]> getCommits(String uri) {
        HttpHeaders head = new HttpHeaders();
        if (token != "") {
            head.set("Authorization", "Bearer" + token);
        }
        HttpEntity<CommitGitHub[]> request = new HttpEntity<>(null, head);
        ResponseEntity<CommitGitHub[]> res = restTemplate.exchange(uri, HttpMethod.GET, request, CommitGitHub[].class);
        return res;
    }

    public ResponseEntity<IssueGitHub[]> getIssues(String uri) {
        HttpHeaders head = new HttpHeaders();
        if (token != "") {
            head.set("Authorization", "Bearer" + token);
        }
        HttpEntity<IssueGitHub[]> request = new HttpEntity<>(null, head);
        ResponseEntity<IssueGitHub[]> res = restTemplate.exchange(uri, HttpMethod.GET, request, IssueGitHub[].class);
        return res;
    }

    public Project postGitHubMinerProject(String owner, String repo, int sinceCommits, int sinceIssues, int maxPages) {
        String uri = "http://localhost:8082/gitminer/projects";
        Project project = findGitMinerProject(owner, repo, sinceCommits, sinceIssues, maxPages);
        Project project1 = restTemplate.postForObject(uri, project, Project.class);
        return project1;

    }

    public Project getProjectById(String id, String repo, int sinceCommits , int sinceIssues,int maxPages){

        String token = "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";
        String url = "http://localhost:8082/gitminer/projects" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Project> response = restTemplate.exchange(url, HttpMethod.GET, entity, Project.class);
        Project project = response.getBody();

        return project;
    }
}
