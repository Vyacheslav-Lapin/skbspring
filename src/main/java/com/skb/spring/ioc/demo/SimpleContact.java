package com.skb.spring.ioc.demo;

import lombok.Value;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Value
public class SimpleContact implements Contact {
    String type;
    String value;
}
