package aiss.GitHubMiner.service;

import aiss.GitHubMiner.model.*;
import aiss.GitHubMiner.post.*;
import org.aspectj.weaver.patterns.PerObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProjectService {

    @Autowired
    private RestTemplate restTemplate;

    private final String token = "tu-token-aqui";
}