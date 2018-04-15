package com.skb.lombok.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

import static lombok.AccessLevel.PRIVATE;

@Data//@Getter @Setter @EqualsAndHashCode @ToString
@FieldDefaults(level = PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
//@Value //@FieldDefaults(level = PRIVATE, makeFinal = true) @Getter @EqualsAndHashCode @ToString @RequiredArgsConstructor
public class Person {
    //    @Wither
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
