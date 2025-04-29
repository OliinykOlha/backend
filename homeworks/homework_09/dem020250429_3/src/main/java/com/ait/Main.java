package com.ait;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();

        int postId = 5;
        URI uri = new URI("https://jsonplaceholder.typicode.com/comments?postId=" + postId);

        RequestEntity<String> request = new RequestEntity<>(HttpMethod.GET, uri);
        ResponseEntity<ArrayList<CommentsDto>> response = restTemplate.exchange(request,
                new ParameterizedTypeReference<ArrayList<CommentsDto>>() {}
        );

        ArrayList<CommentsDto> comments = response.getBody();

        for(CommentsDto comment : comments) {
            System.out.println("ID : " + comment.getId());
            System.out.println("Body : " + comment.getBody());
            System.out.println();
        }

    }
}