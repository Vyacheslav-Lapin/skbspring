package lab.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@Data
@Component("country")
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class SimpleCountry implements Country {

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
