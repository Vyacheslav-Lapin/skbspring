package lab.aop;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Aspect of {@link Politeness#sellSquishee}
 */
@Target(METHOD)
@Retention(RUNTIME)
public @interface Polite {
}
