package aiss.GitHubMiner.service;

import aiss.GitHubMiner.post.Commit;
import aiss.GitHubMiner.post.User;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CommitService {
    RestTemplate restTemplate;
    final String baseUri = "https://api.github.com";
    public List<Commit> sinceCommits(){
        String token = "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";
        String url = "https://api.github.com";

        HttpHeaders headers= new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Commit[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, Commit[].class);
        Commit[] commits = response.getBody();

        return Arrays.asList(commits);
        }
        /*String token = "glpat-3Ty1dCruj56ssUWEWdwJ";
        String url = "https://gitlab.com/api/v4/users";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<User[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, User[].class);
        User[] users = response.getBody();

        return Arrays.asList(users);*/

}



