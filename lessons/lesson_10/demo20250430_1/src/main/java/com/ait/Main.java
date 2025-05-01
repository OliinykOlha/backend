package com.ait;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


public class Main {
    public static void main(String[] args) {

        String imgUrl = "https://imagga.com/static/images/tagging/wind-farm-538576_640.jpg";
        String lang = "de,en,ru";
        String token = "Basic YWNjXzlkNTY0MzVkMjllM2U4MzowOGIxODc3Yzg5ZGZhNDk1ZDgzNmY4N2EyYTkyNTVkOQ==";
        String url = "https://api.imagga.com/v2/tags";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);

        URI uri = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("image_url", imgUrl)
                .queryParam("language", lang)
                .build()
                .toUri();

        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, uri);

        ResponseEntity<TagsResponseDto> response = restTemplate.exchange(request, TagsResponseDto.class);

        response.getBody().getResult().getTags().forEach(System.out::println);

    }
}