package com.ait;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Parameter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("https://jsonplaceholder.typicode.com/comments");

        RequestEntity<String> request = new RequestEntity<>(HttpMethod.GET, uri);

        ResponseEntity<ArrayList<CommentDto>> response = restTemplate.exchange(request,
                new ParameterizedTypeReference<ArrayList<CommentDto>>() {});

        ArrayList<CommentDto> comments = response.getBody();

        for(CommentDto comment : comments) {
            System.out.println(comment.getPostId());
            System.out.println(comment.getBody());
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter number of post");
        Integer postId = scanner.nextInt();

        comments.stream().filter(comment -> comment.getPostId() == postId)
                .forEach(comment -> {
                    System.out.println(comment.postId);
                    System.out.println(comment.getBody());
                });


    }
}