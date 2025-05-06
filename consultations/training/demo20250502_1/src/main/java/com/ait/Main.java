package com.ait;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[] words = {"Hello", "Mama", "Lisa"};
        for(int i = 0; i<= words.length; i++) {
            if(words[i] == "Mama") {
                System.out.println(i);
            }
            System.out.println(words[i] + 1);
        }
    }
}