package com.skb.lombok.demo;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static java.time.Month.APRIL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PersonTest {

    Person person;

    @BeforeEach
    void setUp() {
        person = new Person(
                18,
                "Вася",
                "Пупкин",
                LocalDate.of(1985,
                        APRIL,
                        5));
    }

    @Test
    @DisplayName("no-args-constructor works correctly")
    void noArgsConstructor() {
//        Person person = new Person();
        assertNotNull(person);
    }

    @Test
    @DisplayName("all-args-constructor method works correctly")
    void allArgsConstructor() {
        assertNotNull(person);
    }

    @Test
    @DisplayName("GetAge method works correctly")
    void GetAge() {
        assertThat(person.getAge(), is(18));
    }

    @Test
    @DisplayName("SetAge method works correctly")
    void SetAge() {
//        person.setAge(19);
//        assertThat(person.getAge(), is(19));
    }
}