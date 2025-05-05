package com.ait;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.ait.ResultDto;

import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String url = "https://api.apilayer.com/fixer/convert";
        String token = "U5JiP1fSNUkrhzPwmHmLnyHCiP0gGzmA";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("apikey", token);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите валюту которую хотите перевести: ");
        String from = scanner.nextLine();
        System.out.println("Введите валюту в  которую хотите сделать перевод: ");
        String to = scanner.nextLine();
        System.out.println("Введите сумму: ");
        double amount = scanner.nextDouble();

        URI uri = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("from", from)
                .queryParam("to", to)
                .queryParam("amount", amount)
                .build()
                .toUri();

        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, uri);
        ResponseEntity<ResultDto> response = restTemplate.exchange(request, ResultDto.class);

        System.out.printf(" %.2f %s%n", response.getBody().getResult(), to);


    }
}