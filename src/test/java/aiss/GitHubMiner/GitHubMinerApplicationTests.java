package aiss.GitHubMiner;

import aiss.GitHubMiner.model2.*;
import aiss.GitHubMiner.service.GitHubService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class GitHubMinerApplicationTests {

		@Autowired
		GitHubService gitHubService;

		@Test
		@DisplayName("Get a user")
		void findUser () {
			String owner = "octocat";
			User user = gitHubService.findUser(owner);
			System.out.println(user);
		}
		@Test
		@DisplayName("Get commits")
		void findCommitsByOwnerAndRepo () {
			String owner = "octocat";
			String repo =  "hello-world";
			Integer sinceCommits = 3;
			Integer sinceIssues = 20;
			Integer maxPages = 2;
			List<Commit> commits = gitHubService.findCommitsByOwnerAndRepo(owner,repo,sinceCommits,maxPages);
			System.out.println(commits);

		}
		@Test
		@DisplayName("Get Issues")
		void findIssuesByOwnerAndRepo () {
			String owner = "octocat";
			String repo =  "hello-world";
			Integer sinceCommits = 3;
			Integer sinceIssues = 20;
			Integer maxPages = 2;
			List<Issue> issues = gitHubService.findIssuesByOwnerAndRepo(owner,repo,sinceIssues,maxPages);
			System.out.println(issues);

		}
		@Test
		@DisplayName("GetCommentById")
		void findCommentById () {
			String owner = "octocat";
			String repo =  "hello-world";
			Integer id = 33;
			Integer maxPages = 2;
		    List<Comment> comments = gitHubService.findCommentById(owner,repo,id,maxPages);
			System.out.println(comments);

		}
		@Test
		@DisplayName("Get a Project")
		void findProjectByOwnerAndRepo () {
			String owner = "octocat";
			String repo =  "hello-world";
			Integer sinceCommits = 3;
			Integer sinceIssues = 20;
			Integer maxPages = 2;
			Project project = gitHubService.findProjectByOwnerAndRepo(owner,repo,sinceCommits,sinceIssues,maxPages);
			System.out.println(project);

	}
	}


