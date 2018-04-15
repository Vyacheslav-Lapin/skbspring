package com.skb.lombok.demo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data//@Getter @Setter @EqualsAndHashCode @ToString
@Log4j2
@Builder // @AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@NoArgsConstructor
//@Value //@FieldDefaults(level = PRIVATE, makeFinal = true) @Getter @EqualsAndHashCode @ToString @RequiredArgsConstructor
public class Person {
    //    @Wither
    @Builder.Default
    int age = 18;
    String firstName;
    String lastName;
    LocalDate dob;

    @Singular
    List<String> contacts;

    public void jhgsd(){
        try (EntityManager entityManager = null) {
            entityManager.merge(new Person());
        }
    }

//    public static void main(String... arguments) {
//        for (Method method : Person.class.getDeclaredMethods()) {
//            for (Parameter parameter : method.getParameters()) {
//                System.out.println(parameter.getName());
//            }
//        }
//    }
}
