package lab.common;

import java.util.function.Consumer;

import static lab.common.CheckedConsumerModule.sneakyThrow;

public interface CheckedConsumer<T> extends io.vavr.CheckedConsumer<T> {

    static <T> CheckedConsumer<T> of(CheckedConsumer<T> checkedConsumer) {
        return checkedConsumer;
    }

    /**
     * Returns an unchecked function that will <em>sneaky throw</em> if an exceptions occurs when applying the function.
     *
     * @return a new Consumer that throws a {@code Throwable}.
     */
    default Consumer<T> unchecked() {
        return t -> {
            try {
                accept(t);
            } catch(Throwable thr) {
                sneakyThrow(thr);
            }
        };
    }
}

interface CheckedConsumerModule {

    // DEV-NOTE: we do not plan to expose this as public API
    @SuppressWarnings("unchecked")
    static <T extends Throwable, R> R sneakyThrow(Throwable t) throws T {
        throw (T) t;
    }
}