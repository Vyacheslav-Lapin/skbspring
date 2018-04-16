package com.skb.spring.ioc.demo;

import lab.model.Contact;
import lombok.Value;

import java.util.List;

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
