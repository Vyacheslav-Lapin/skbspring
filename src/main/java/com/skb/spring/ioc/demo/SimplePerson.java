package com.skb.spring.ioc.demo;

import lombok.Value;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Value
public class SimplePerson implements Person {
    String firstName;
    String lastName;
    Country country;
    int age;
    float height;
    boolean isProgrammer;
    boolean broke;
    List<Contact> contacts;
}
