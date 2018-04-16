package com.skb.spring.ioc;

import lab.JavaConfig;
import lab.model.Person;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static lombok.AccessLevel.PRIVATE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
//@ContextConfiguration("classpath:ioc.xml")
@ContextConfiguration(classes = JavaConfig.class)
@FieldDefaults(level = PRIVATE)
class SpringTCFAppTest {

    Person person;

    @Test
    void testInitPerson() {
        assertThat(person,
                is(HelloWorldTest.getExpectedPerson()));
    }

}
