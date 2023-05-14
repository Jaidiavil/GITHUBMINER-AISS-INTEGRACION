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
    @Autowired
    GitHubService service;

    @GetMapping("/{owner}/{repo}")
    public Project getDataGitHub(@PathVariable String owner, @PathVariable String repo,
                                 @RequestParam(value  = "sinceCommits", required = false, defaultValue = "5") Integer sinceCommits,
                                 @RequestParam(value  = "sinceIssues", required = false, defaultValue = "20") Integer sinceIssues,
                                 @RequestParam(value  = "maxPages", required = false, defaultValue = "2") Integer maxPages){
        return service.findGitMinerProject(owner,repo,sinceCommits,sinceIssues,maxPages);
    }
    @PostMapping("/{owner}/{repo}")
    @ResponseStatus(HttpStatus.CREATED)
    public Project postDataGitHub(@PathVariable String owner, @PathVariable String repo,
                                  @RequestParam(value  = "sinceCommits", required = false, defaultValue = "5") Integer sinceCommits,
                                  @RequestParam(value  = "sinceIssues", required = false, defaultValue = "20") Integer sinceIssues,
                                  @RequestParam(value  = "maxPages", required = false, defaultValue = "2") Integer maxPages){
        return service.postGitHubMinerProject(owner,repo,sinceCommits,sinceIssues,maxPages);
    }

}