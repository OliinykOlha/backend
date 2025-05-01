package com.ait;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер поста: ");
        int postId = scanner.nextInt();

        URI uri = new URI("https://jsonplaceholder.typicode.com/comments?postId=" + postId);

        RequestEntity<String> request = new RequestEntity<>(HttpMethod.GET, uri);
        ResponseEntity<ArrayList<CommentsDto>> response = restTemplate.exchange(request,
                new ParameterizedTypeReference<ArrayList<CommentsDto>>() {});

        ArrayList<CommentsDto> comments = response.getBody();


        for (var comment : comments) {

            System.out.println("ID : " + comment.getPostId());
            System.out.println("Body : " + comment.getBody());
            System.out.println();
        }


    }
}