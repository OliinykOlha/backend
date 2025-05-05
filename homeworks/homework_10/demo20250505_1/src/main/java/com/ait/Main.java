package com.ait;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String imgUrl = "https://cdn.javarush.com/images/article/431abcb1-71aa-4137-97bd-ad26d7aa0e00/800.jpeg";
        String token = "Basic YWNjXzlkNTY0MzVkMjllM2U4MzowOGIxODc3Yzg5ZGZhNDk1ZDgzNmY4N2EyYTkyNTVkOQ==";
        String url = "https://api.imagga.com/v2/text";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);

        URI uri = UriComponentsBuilder.fromUriString(url)
                .queryParam("image_url", imgUrl)
                .build()
                .toUri();

        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, uri);

        ResponseEntity<ResultDto> response = restTemplate.exchange(request, ResultDto.class);


        List<DataDto> textItems =  response.getBody().getResult().getText();

        String joinedText = textItems.stream()
                .map(DataDto::getData)
                .collect(Collectors.joining(" "));

        System.out.println(joinedText);



    }


}