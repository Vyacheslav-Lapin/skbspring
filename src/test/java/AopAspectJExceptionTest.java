import lab.JavaConfig;
import lab.common.TestUtils;
import lab.model.Bar;
import lab.model.CustomerBrokenException;
import lab.model.Person;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static lab.common.TestUtils.executeAndGetFromSout;
import static lombok.AccessLevel.PRIVATE;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@ExtendWith(SpringExtension.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
@ContextConfiguration(classes = JavaConfig.class)
@FieldDefaults(level = PRIVATE)
class AopAspectJExceptionTest {

    final Bar bar;

    Person person;

    @BeforeEach
    void setUp() {
        person = person.withBroke(true);
    }

    @Test
    void testAfterThrowingAdvice() {

        String sout = executeAndGetFromSout(() ->
                assertThrows(CustomerBrokenException.class, () ->
                        bar.sellSquishee(person)));

        assertTrue("Customer is not broken ",
                sout.contains("Hmmm..."));
    }
}