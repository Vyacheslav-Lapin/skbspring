package lab.common;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import lombok.experimental.UtilityClass;
import lombok.val;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@UtilityClass
public class TestUtils {

    public static String executeAndGetFromSout(Runnable runnable) {
        return fromSout(stringSupplier -> {
            runnable.run();
            return stringSupplier.get();
        });
    }

    public static <T> Tuple2<T, String> executeAndGetResultWithSout(Supplier<T> supplier) {
        return fromSout(stringSupplier -> Tuple.of(
                supplier.get(),
                stringSupplier.get()));
    }

    private static <T> T fromSout(Function<Supplier<String>, T> mapper) {
        PrintStream realOut = System.out;

        val byteArrayOutputStream = new ByteArrayOutputStream();

        Supplier<String> stringSupplier =
                () -> new String(
                        byteArrayOutputStream.toByteArray())
                        .intern();

        try (val out = new PrintStream(byteArrayOutputStream)) {
            System.setOut(out);
            return mapper.apply(stringSupplier);
        } finally {
            System.setOut(realOut);
        }

    }
}
