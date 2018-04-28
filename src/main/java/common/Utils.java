package common;

import io.vavr.Tuple2;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

@UtilityClass
public class Utils {

    @SafeVarargs
    public static <K, V> Map mapOf(Tuple2<K, V>... keyAndValuePairs) {
        return Collections.unmodifiableMap(
                Arrays.stream(keyAndValuePairs)
                        .collect(Collectors.toMap(
                                keyAndValue -> keyAndValue._1,
                                keyAndValue -> keyAndValue._2)));
    }
}
