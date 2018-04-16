package com.skb.spring.ioc;

import lab.model.Person;
import lab.model.SimpleContact;
import lab.model.SimpleCountry;
import lab.model.UsualPerson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloWorldTest {

    static final String APPLICATION_CONTEXT_XML_FILE_NAME =
            "ioc.xml";

    private BeanFactory context = new ClassPathXmlApplicationContext(
            APPLICATION_CONTEXT_XML_FILE_NAME
    );

    @Test
    void testInitPerson() {
        assertEquals(getExpectedPerson(), context.getBean("person"));
    }

    public static Person getExpectedPerson() {
        return new UsualPerson(
                1,
                "John Smith",
                new SimpleCountry(1, "Russia", "RU"),
                35,
                1.78f,
                true,
                Arrays.asList(
                        new SimpleContact("EMAIL", "asd@asd.ru"),
                        new SimpleContact("TELEPHONE", "+55 11 99999-5555")));
    }
}
