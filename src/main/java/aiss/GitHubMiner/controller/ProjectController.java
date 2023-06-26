package aiss.GitHubMiner.controller;

import aiss.GitHubMiner.Except.ProjectNotFound;
import aiss.GitHubMiner.model.ProjectGitMiner;
import aiss.GitHubMiner.model2.Project;
import aiss.GitHubMiner.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/githubminer")
public class ProjectController {
    //POST http://localhost:8082/githubminer/{owner}/{repoName}
    @Autowired
    GitHubService service;
    /*
@PostMapping("/{owner}/{repo}")
@ResponseStatus(HttpStatus.CREATED)
public ProjectGitMiner createProject(@PathVariable String owner, @PathVariable String repo,
                                     @RequestParam(defaultValue = "2") Integer sinceCommits,
                                     @RequestParam(defaultValue = "20") Integer sinceIssues,
                                     @RequestParam(defaultValue = "2") Integer maxPages) throws ProjectNotFound {
    Optional<Project> pro = service.findProjectByOwnerAndRepo(owner,repo,sinceCommits,sinceIssues,maxPages);
    if (pro.isPresent()){
        return pro.get();
    }
    else {
        throw new ProjectNotFound();

    ProjectGitMiner res = service.createProject(project);


    return res;
}
*/
    // GET http://localhost:8082/api/projects/{owner}/{repo}
    @GetMapping("/{owner}/{repo}")
    public Project findOne(@PathVariable String owner, @PathVariable String repo,
                           @RequestParam(defaultValue = "2") Integer sinceCommits,
                           @RequestParam(defaultValue = "20") Integer sinceIssues,
                           @RequestParam(defaultValue = "2") Integer maxPages) throws ProjectNotFound {

        Optional<Project> pro = service.findProjectByOwnerAndRepo(owner,repo,sinceCommits,sinceIssues,maxPages);
        if (pro.isPresent()){
            return pro.get();
        }
        else {
            throw new ProjectNotFound();
        }
    }

}