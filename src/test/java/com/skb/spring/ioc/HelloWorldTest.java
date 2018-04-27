package com.skb.spring.ioc;

import lab.model.Person;
import lab.model.SimpleContact;
import lab.model.SimpleCountry;
import lab.model.UsualPerson;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.jupiter.api.Assertions.assertEquals;

@FieldDefaults(level = PRIVATE, makeFinal = true)
class HelloWorldTest {

    static String APPLICATION_CONTEXT_XML_FILE_NAME =
            "ioc.xml";

    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext("lab");

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
                false,
                Arrays.asList(
                        new SimpleContact("EMAIL", "asd@asd.ru"),
                        new SimpleContact("TELEPHONE", "+55 11 99999-5555")));
    }
}
