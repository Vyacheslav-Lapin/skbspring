package com.skb.spring.ioc.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class SimplePersonTest {

    static final String APPLICATION_CONTEXT_XML_FILE_NAME =
            "ioc.xml";

    BeanFactory context =
            new ClassPathXmlApplicationContext(
                    APPLICATION_CONTEXT_XML_FILE_NAME);

    @Test
    @DisplayName("Injection method works correctly")
    void inject() {
//        Person person = context.getBean("person", Person.class);
        assertThat(context.getBean("person"), is(getExpectedPerson()));
    }

    private Person getExpectedPerson() {
        return new SimplePerson(
                "John",
                "Smith",
                new SimpleCountry("Russia", "RU"),
                35,
                1.78f,
                true,
                false,
                asList(
                        new SimpleContact("EMAIL", "asd@asd.ru"),
                        new SimpleContact("TELEPHONE", "+55 11 99999-5555")));
    }
}