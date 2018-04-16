package com.skb.spring.ioc;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.jupiter.api.Assertions.assertEquals;

@FieldDefaults(level = PRIVATE)
class SimpleAppTest {

//    static final String APPLICATION_CONTEXT_XML_FILE_NAME = "classpath:ioc.xml";

    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext();

    @BeforeEach
    void setUp() {
        context.scan("lab");
        context.refresh();
    }

    @Test
    void testInitPerson() {
        //		FYI: Another way to achieve the bean
//		person = context.getBean(UsualPerson.class);
        assertEquals(HelloWorldTest.getExpectedPerson(), context.getBean("person"));
    }
}
