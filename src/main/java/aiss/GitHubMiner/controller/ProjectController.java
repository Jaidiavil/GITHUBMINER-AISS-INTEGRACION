package aiss.GitHubMiner.controller;

import aiss.GitHubMiner.post.*;
import aiss.GitHubMiner.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/githubminer")
public class ProjectController {
    @Autowired
    RestTemplate template;
    @Autowired
    ProjectService projectService;

    final String gitMinerUri= "http://localhost:8080/gitminer/v1/projects";


    //POST http://localhost:8082/githubminer/{owner}/{repoName}
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{owner}/{repoName}")
    public Project createProject(@PathVariable String owner, @PathVariable String repoName, @RequestParam(defaultValue = "5") Integer sinceCommits,
                                 @RequestParam(defaultValue = "20") Integer sinceIssues, @RequestParam(defaultValue = "2") Integer maxPages) {
        Project project = projectService.getProject(owner, repoName, sinceCommits, sinceIssues, maxPages);
        HttpEntity<Project> request = new HttpEntity<>(project);
        ResponseEntity<Project> response = template.exchange(gitMinerUri, HttpMethod.POST, request, Project.class);
        return response.getBody();
    }

    //GET http://localhost:8082/githubminer/{owner}/{repoName}
    @GetMapping("/{owner}/{repoName}")
    public Project findProject(@PathVariable String owner, @PathVariable String repoName, @RequestParam(defaultValue = "5") Integer sinceCommits,
                               @RequestParam(defaultValue = "20") Integer sinceIssues, @RequestParam(defaultValue = "2") Integer maxPages) {
        return projectService.getProject(owner, repoName, sinceCommits, sinceIssues, maxPages);
    }
}