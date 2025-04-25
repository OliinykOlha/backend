package com.ait;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Person person = new Person("Jack", 18);
        Person[] persons = {
                new Person("John", 25),
                new Person("Jenna", 27),
                new Person("Bill", 35),
                new Person("Mike", 25)
        };

        try {
            String json = mapper.writeValueAsString(person);
            try {
//                 .................
                mapper.writeValue(new File("p1.json"), person);
                mapper.writeValue(new File("p2.json"), persons);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

       Person person1 = mapper.readValue(new File("p1.json"), Person.class);
       Person[] people1 = mapper.readValue(new File("p2.json"), Person[].class);
        System.out.println("person : " + person1);
        System.out.println(Arrays.toString(people1));

    }
}