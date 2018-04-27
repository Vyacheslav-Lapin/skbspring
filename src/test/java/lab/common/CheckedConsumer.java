package lab.common;

public interface CheckedConsumer<T> extends io.vavr.CheckedConsumer<T> {

    static <T> CheckedConsumer<T> of(CheckedConsumer<T> checkedConsumer) {
        return checkedConsumer;
    }
}
