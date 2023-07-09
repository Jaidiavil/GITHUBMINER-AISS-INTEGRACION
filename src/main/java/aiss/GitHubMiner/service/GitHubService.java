package aiss.GitHubMiner.service;

import aiss.GitHubMiner.Except.ProjectNotFound;
import aiss.GitHubMiner.model.ProjectGitMiner;
import aiss.GitHubMiner.model2.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@Service
public class GitHubService {
    @Autowired
    RestTemplate restTemplate;
    @Value("${github-miner.token}")
    private String token;

    private HttpHeaders getHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+token);

        return  headers;
    }

    public User findUser(String owner){
        String uri = "https://api.github.com/users/" + owner;
        HttpHeaders headers = getHeader();

        HttpEntity<Commit[]> entity = new HttpEntity<>(null, headers);

        ResponseEntity<User> userSearch = restTemplate.exchange(uri, HttpMethod.GET, entity, User.class);
        return userSearch.getBody();

    }
    public List<Commit> findCommitsByOwnerAndRepo(String owner, String repo,Integer sinceCommits,Integer maxPages){
        List<Commit> commits = null;
        String uri = "https://api.github.com/repos/" + owner + "/"+ repo + "/commits?since=" + LocalDate.now().minusDays(sinceCommits) +"&per_page=" + maxPages;
        HttpHeaders headers = getHeader();

        HttpEntity<Commit[]> entity = new HttpEntity<>(null, headers);

        ResponseEntity<Commit[]> commitSearch = restTemplate.exchange(uri, HttpMethod.GET, entity, Commit[].class);
        commits = Arrays.asList(commitSearch.getBody());
        return commits;
    }
    public List<Issue> findIssuesByOwnerAndRepo(String owner, String repo,Integer sinceIssues,Integer maxPages){
        List<Issue> issues = null;
        String uri = "https://api.github.com/repos/" + owner + "/"+ repo + "/issues?since=" + LocalDate.now().minusDays(sinceIssues)+"&per_page=" + maxPages;;

        HttpHeaders headers = getHeader();

        HttpEntity<Issue[]> entity = new HttpEntity<>(null, headers);

        ResponseEntity<Issue[]> issuesSearch = restTemplate.exchange(uri, HttpMethod.GET, entity, Issue[].class);

        Issue[] allIssues = issuesSearch.getBody();
        for(Issue e: allIssues){
            e.setUser(findUser(e.getUser().getUsername()));
            e.setComment(findCommentById(owner, repo,e.getIid(),maxPages));
        }

        return Arrays.asList(allIssues);
    }
    public List<Comment> findCommentById(String owner, String repo,Integer iid,Integer maxPages){
        List<Comment> issues = null;
        String uri = "https://api.github.com/repos/" + owner + "/"+ repo + "/issues/" + iid.toString() + "/comments?per_page=" + maxPages;
        HttpHeaders headers = getHeader();
        HttpEntity<Comment> entity = new HttpEntity<Comment>(null, headers);
        ResponseEntity<Comment[]> commentSearch = restTemplate.exchange(uri, HttpMethod.GET, entity, Comment[].class);
        Comment[] comments = commentSearch.getBody();
        return Arrays.asList(comments);
    }
    public Project findProjectByOwnerAndRepo(String owner, String repo,Integer sinceCommits,Integer sinceIssues,Integer maxPages) throws ProjectNotFound {
        Project project = null;
        String uri = "https://api.github.com/repos/" + owner + "/" + repo + "?per_page=" + maxPages;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<Project> entity = new HttpEntity<Project>(null, headers);


        ResponseEntity<Project> projectSearch;
        try {
            projectSearch = restTemplate.exchange(uri, HttpMethod.GET, entity, Project.class);

        } catch (Exception e) {
            throw new ProjectNotFound();
        }

        project = projectSearch.getBody();
        project.setCommit(findCommitsByOwnerAndRepo(owner, repo, sinceCommits, maxPages));
        project.setIssues(findIssuesByOwnerAndRepo(owner, repo, sinceIssues, maxPages));

        return project;
    }

    public ProjectGitMiner createProject(Project project){
        String uri = "http://localhost:8080/gitminer";
        ProjectGitMiner res = restTemplate.postForObject(uri, project, ProjectGitMiner.class);

        return res;
    }
}
