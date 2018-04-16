package lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.ListFactoryBean;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class UsualPerson implements Person {
    int id;

    String name;

    Country country;

    int age;
    float height;
    boolean isProgrammer;

    List<String> contacts;
}