package lab.model;

import org.jetbrains.annotations.NotNull;

public interface Person {
    String getName();

    Person setName(String name);

    default void sayHello(@NotNull Person person) {
        System.out.printf(
                "Hello, %s, I`m %s",
                person.getName(),
                getName()
        );
    }
}