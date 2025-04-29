package com.ait;

import lombok.*;

import lombok.AllArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Person {
    private String name;
    private int age;
    private int weight;
    private int height;

}
