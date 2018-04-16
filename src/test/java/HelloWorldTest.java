import lab.model.Person;
import lab.model.SimpleCountry;
import lab.model.UsualPerson;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloWorldTest {

    static final String APPLICATION_CONTEXT_XML_FILE_NAME =
            "application-context.xml";

    private BeanFactory context = new ClassPathXmlApplicationContext(
            APPLICATION_CONTEXT_XML_FILE_NAME
    );

    @Test
    void testInitPerson() {
        Person person = context.getBean("person", Person.class);
        assertEquals(getExpectedPerson(), person);
        System.out.println(person);
    }

    private Person getExpectedPerson() {
        return new UsualPerson(
                1,
                "John Smith",
                new SimpleCountry(1, "Russia", "RU"),
                35,
                1.78f,
                true,
                Arrays.asList("asd@asd.ru", "+55 11 99999-5555"));
    }
}
