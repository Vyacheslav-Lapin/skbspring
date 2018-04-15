package com.skb.lombok.demo;

import lombok.Value;

import java.time.LocalDate;

//@NoArgsConstructor
//@Data//@Getter @Setter @EqualsAndHashCode @ToString
@Value //@FieldDefaults(level = PRIVATE, makeFinal = true) @Getter @EqualsAndHashCode @ToString @RequiredArgsConstructor

public class Person {
    int age;
    String firstName;
    String lastName;
    LocalDate dob;

//    public static void main(String... arguments) {
//        for (Method method : Person.class.getDeclaredMethods()) {
//            for (Parameter parameter : method.getParameters()) {
//                System.out.println(parameter.getName());
//            }
//        }
//    }
}
