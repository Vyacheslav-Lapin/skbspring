package com.skb.spring.ioc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleAppTest {

    static final String APPLICATION_CONTEXT_XML_FILE_NAME = "classpath:application-context.xml";

    private BeanFactory context = new ClassPathXmlApplicationContext(
            APPLICATION_CONTEXT_XML_FILE_NAME);

    @Test
    void testInitPerson() {
        //		FYI: Another way to achieve the bean
//		person = context.getBean(UsualPerson.class);
        assertEquals(HelloWorldTest.getExpectedPerson(), context.getBean("person"));
    }
}
