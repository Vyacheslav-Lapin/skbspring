package com.skb.spring.ioc.demo;

import lombok.Value;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Value
public class SimpleCountry implements Country {
    String name;
    String codeName;
}
