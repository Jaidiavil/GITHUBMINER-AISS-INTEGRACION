package aiss.GitHubMiner.service;
import aiss.GitHubMiner.post.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import aiss.GitHubMiner.post.Comment;
import org.springframework.http.HttpHeaders;

import java.util.Arrays;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    RestTemplate restTemplate;
    final String baseUri = "https://api.gihub.com/";
    public List<Comment> getNotes(String owner, String repo,String id){
        String uri = baseUri+"/repos/"+owner+"/"+repo+"/issues/"+id +"/comments";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer" +
                "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");
        HttpEntity<String[]> request = new HttpEntity<>(null, headers);
        ResponseEntity<Comment[]> response = restTemplate.exchange(uri,
                HttpMethod.GET, request,Comment[].class);
        List<Comment> comments = Arrays.stream(response.getBody()).toList();
        mapAuthorValues(comments);
        return comments;
    }
    public void mapAuthorValues (List<Comment> comments) {
        for (Comment comment : comments) {
            if (comment != null) {
                User commentAuthor = comment.getAuthor();

                String commentAuthorUserName = commentAuthor.getLogin();
                String commentAuthorName = commentAuthor.getLogin();
                String commentAuthorWebUrl = commentAuthor.getHtmlUrl();

                comment.setAuthor(commentAuthor);
                commentAuthor.setUsername(commentAuthorUserName);
                commentAuthor.setName(commentAuthorName);
                commentAuthor.setWebUrl(commentAuthorWebUrl);

            }
        }

    }

}