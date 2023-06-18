package aiss.GitHubMiner.service;

import aiss.GitHubMiner.model.ProjectGitMiner;
import aiss.GitHubMiner.model2.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    private HttpHeaders getHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer " + token);
        return headers;
    }
    public Project findProject () {
        HttpHeaders h = new HttpHeaders();
        h.setContentType(MediaType.APPLICATION_JSON);
        String uri = baseUri + "/";
        HttpEntity<Object> r = new HttpEntity<>(h);
        ResponseEntity<Project> res = restTemplate.exchange(uri, HttpMethod.GET, r, Project.class);

        return res.getBody();
    }
    public User findUser(String owner){
        String uri = "https://api.github.com/users/" + owner;
        HttpHeaders headers = getHeader();

        HttpEntity<Commit[]> entity = new HttpEntity<>(null, headers);

        ResponseEntity<User> userSearch = restTemplate.exchange(uri, HttpMethod.GET, entity, User.class);
        //User userSearch = restTemplate.getForObject(uri, User.class);
        return userSearch.getBody();

    }
    public Project findAProjectByOwnerAndRepo(String owner, String repo){
        Project project = null;
        String uri = "https://api.github.com/repos/" + owner + "/"+ repo;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer " + token);
        HttpEntity<Project> entity = new HttpEntity<Project>(null, headers);

        ResponseEntity<Project> projectSearch = restTemplate.exchange(uri, HttpMethod.GET, entity, Project.class);
        project = projectSearch.getBody();
        project.setCommit(findCommitsByOwnerAndRepo(owner,repo));
        project.setIssues(findIssuesByOwnerAndRepo(owner,repo));

        return project;
    }
    public List<Commit> findCommitsByOwnerAndRepo(String owner, String repo){
        List<Commit> commits = null;
        String uri = "https://api.github.com/repos/" + owner + "/"+ repo + "/commits";
        HttpHeaders headers = getHeader();

        HttpEntity<Commit[]> entity = new HttpEntity<>(null, headers);

        ResponseEntity<Commit[]> commitSearch = restTemplate.exchange(uri, HttpMethod.GET, entity, Commit[].class);
        commits = Arrays.asList(commitSearch.getBody());
        //Commit[] commitSearch = restTemplate.getForObject(uri, Commit[].class);

        return commits;
    }
    public List<Issue> findIssuesByOwnerAndRepo(String owner, String repo){
        List<Issue> issues = null;
        String uri = "https://api.github.com/repos/" + owner + "/"+ repo + "/issues";

        HttpHeaders headers = getHeader();

        HttpEntity<Issue[]> entity = new HttpEntity<>(null, headers);

        ResponseEntity<Issue[]> issuesSearch = restTemplate.exchange(uri, HttpMethod.GET, entity, Issue[].class);

        Issue[] allIssues = issuesSearch.getBody();

        //Issue[] issuesSearch = restTemplate.getForObject(uri, Issue[].class);
        for(Issue e: allIssues){
            e.setUser(findUser(e.getUser().getUsername()));
            e.setComment(findCommentByIid(owner, repo,e.getIid()));
        }

        return Arrays.asList(allIssues);
    }
    public List<Comment> findCommentByIid(String owner, String repo, Integer iid){
        List<Comment> issues = null;
        String uri = "https://api.github.com/repos/" + owner + "/"+ repo + "/issues/" + iid.toString() + "/comments";
        HttpHeaders headers = getHeader();
        HttpEntity<Comment> entity = new HttpEntity<Comment>(null, headers);
        ResponseEntity<Comment[]> commentSearch = restTemplate.exchange(uri, HttpMethod.GET, entity, Comment[].class);
        Comment[] comments = commentSearch.getBody();
        return Arrays.asList(comments);
    }
    public List<Commit> findAllCommitsProject(String owner, String repository) {
        Commit[] commits = restTemplate.
                getForObject(baseUri + owner + "/" + repository + "/commits", Commit[].class);
        return Arrays.
                stream(commits).
                toList();
    }

    public Project findGitMinerProject(String owner, String repo, int sinceCommits, int sinceIssues, int maxPages) {
        Project project = new Project(findProject());
        Project project1 = new Project(project.getId(), project.getName(), project.getWebUrl());
        return project1;
    }

    public ResponseEntity<Commit[]> getCommits(String uri) {
        HttpHeaders head = new HttpHeaders();
        if (token != "") {
            head.set("Authorization", "Bearer" + token);
        }
        HttpEntity<Commit[]> request = new HttpEntity<>(null, head);
        ResponseEntity<Commit[]> res = restTemplate.exchange(uri, HttpMethod.GET, request, Commit[].class);
        return res;
    }

    public ResponseEntity<Issue[]> getIssues(String uri) {
        HttpHeaders head = new HttpHeaders();
        if (token != "") {
            head.set("Authorization", "Bearer" + token);
        }
        HttpEntity<Issue[]> request = new HttpEntity<>(null, head);
        ResponseEntity<Issue[]> res = restTemplate.exchange(uri, HttpMethod.GET, request, Issue[].class);
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
    public ProjectGitMiner createProject(Project project){
        String uri = "http://localhost:8080/gitminer/projects";

        ProjectGitMiner res = restTemplate.postForObject(uri, project, ProjectGitMiner.class);

        return res;
    }
}
