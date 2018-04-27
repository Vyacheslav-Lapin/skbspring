package lab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Getter
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Squishee {
    String name;
}
