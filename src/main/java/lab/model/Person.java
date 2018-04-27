package lab.model;

import org.jetbrains.annotations.NotNull;

public interface Person {
    String getName();

    Person setName(String name);

    boolean isBroke();

    default void sayHello(@NotNull Person person) {
        System.out.printf(
                "Hello, %s, I`m %s",
                person.getName(),
                getName()
        );
    }

    Person withBroke(boolean isBroke);
}