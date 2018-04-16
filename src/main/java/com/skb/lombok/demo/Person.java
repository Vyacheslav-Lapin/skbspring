package com.skb.lombok.demo;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

//@Data//@Getter @Setter @EqualsAndHashCode @ToString
//@Log4j2
//@Builder // @AllArgsConstructor
//@FieldDefaults(level = PRIVATE)
//@NoArgsConstructor
@Value //@FieldDefaults(level = PRIVATE, makeFinal = true) @Getter @EqualsAndHashCode @ToString @RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"age", "dob"})
public class Person {
    //    @Wither
//    @Builder.Default
    int age = 18;
    String firstName;
    String lastName;
    LocalDate dob;

    //    @Singular
    List<String> contacts;

    public void jhgsd() {
//        try (EntityManager entityManager = null) {
//            entityManager.merge(new Person());
//        }
    }

//    public static void main(String... arguments) {
//        for (Method method : Person.class.getDeclaredMethods()) {
//            for (Parameter parameter : method.getParameters()) {
//                System.out.println(parameter.getName());
//            }
//        }
//    }
}
