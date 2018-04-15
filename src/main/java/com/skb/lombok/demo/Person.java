package com.skb.lombok.demo;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

import static lombok.AccessLevel.NONE;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Person {
    int age;
    String firstName;
    String lastName;
}
