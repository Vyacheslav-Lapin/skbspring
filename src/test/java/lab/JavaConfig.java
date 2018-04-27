package lab;

import lab.model.Contact;
import lab.model.SimpleContact;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.*;

import java.util.Arrays;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Configuration
//@ComponentScan("lab.model")
@AllArgsConstructor
@ImportResource("aop.xml")
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class JavaConfig {

    @Bean
    public List<Contact> contacts() {
        return Arrays.asList(
                new SimpleContact("EMAIL", "asd@asd.ru"),
                new SimpleContact("TELEPHONE", "+55 11 99999-5555"));
    }
}
