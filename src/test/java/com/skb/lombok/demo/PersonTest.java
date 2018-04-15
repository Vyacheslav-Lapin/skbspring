package com.skb.lombok.demo;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static java.time.Month.APRIL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonTest {

    Person person;

    @BeforeEach
    void setUp() {
        person = Person.builder()
                .firstName("Вася")
                .lastName("Пупктин")
                .dob(LocalDate.of(1985,
                        APRIL,
                        5))
                .build();
    }

    @Test
    @DisplayName("bulder works correctly")
    void builder() {

        ;

        assertTrue(Person.builder()
                .contact("222-33-22")
                .contact("kjhsdf@kjhsdg.com")
                .build().getContacts().contains("222-33-22"));
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
//        assertThat(person.age(), is(18));
    }

    @Test
    @DisplayName("SetAge method works correctly")
    void SetAge() {
//        Person person = this.person.withAge(19);
        person.setAge(19);
//        person.age(19);

        assertThat(person.getAge(), is(19));
//        assertThat(person.age(), is(19));
        assertThat(person.getFirstName(), is("Вася"));
//        assertThat(person.firstName(), is("Вася"));
    }

    @Test
    @SneakyThrows
    @DisplayName("Name method works correctly")
    void Name() {
        Class.forName("org.apache.logging.log4j.Logger");
    }
}