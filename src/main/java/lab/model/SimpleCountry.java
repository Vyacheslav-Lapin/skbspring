package lab.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@NoArgsConstructor
@Component("country")
@Table(name = "country")
@FieldDefaults(level = PRIVATE)
@EqualsAndHashCode(exclude = "id")
public class SimpleCountry implements Country {

    @Id
    @GeneratedValue
    int id;

    String name;

    String codeName;

    public SimpleCountry(String name, String codeName) {
        this.name = name;
        this.codeName = codeName;
    }

    @Autowired
    public SimpleCountry(int id,
                         @Qualifier("countryName") String name,
                         String codeName) {
        this.id = id;
        this.name = name;
        this.codeName = codeName;
    }
}
