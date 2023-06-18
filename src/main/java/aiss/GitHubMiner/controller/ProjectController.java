package aiss.GitHubMiner.controller;

import aiss.GitHubMiner.model.ProjectGitMiner;
import aiss.GitHubMiner.model2.Project;
import aiss.GitHubMiner.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/githubminer")
public class ProjectController {

    final String gitMinerUri= "http://localhost:8080/gitminer/v1/projects";

    //POST http://localhost:8082/githubminer/{owner}/{repoName}
    @Autowired
    GitHubService service;
@PostMapping("/{owner}/{repo}")
@ResponseStatus(HttpStatus.CREATED)
public ProjectGitMiner createProject(@PathVariable String owner, @PathVariable String repo){
    Project project = service.findProjectByOwnerAndRepo(owner,repo);
    ProjectGitMiner res = service.createProject(project);

    return res;
}

    // GET http://localhost:8082/api/projects/{owner}/{repo}
    @GetMapping("/{owner}/{repo}")
    public Project findOne(@PathVariable String owner, @PathVariable String repo){

        return service.findProjectByOwnerAndRepo(owner,repo);

    }

}