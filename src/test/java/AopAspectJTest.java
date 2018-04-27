import lab.JavaConfig;
import lab.common.TestUtils;
import lab.model.ApuBar;
import lab.model.Bar;
import lab.model.Person;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.naming.Context;
import javax.naming.InitialContext;

import static lab.common.TestUtils.executeAndGetFromSout;
import static lombok.AccessLevel.PRIVATE;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@ExtendWith(SpringExtension.class)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@ContextConfiguration(classes = JavaConfig.class)
@FieldDefaults(level = PRIVATE, makeFinal = true)
class AopAspectJTest {

    Bar bar;

    Person person;

    @NonFinal
    String sout;

    @BeforeEach
    void setUp() {
        sout = executeAndGetFromSout(() -> bar.sellSquishee(person));
    }

    @Test
    void testBeforeAdvice() {
        assertTrue("Before advice is not good enough...",
                sout.contains("Hello"));
        assertTrue("Before advice is not good enough...",
                sout.contains("How are you doing?"));
    }

    @Test
    void testAfterAdvice() {
        assertTrue("After advice is not good enough...",
                sout.contains("Good Bye!"));
    }

    @Test
    void testAfterReturningAdvice() {
        assertTrue("Customer is broken",
                sout.contains("Good Enough?"));
    }

    @Test
    void testAroundAdvice() {
        assertTrue("Around advice is not good enough...",
                sout.contains("Hi!"));

        assertTrue("Around advice is not good enough...",
                sout.contains("See you!"));
    }

    @Test
    void testAllAdvices() {
        assertFalse(bar instanceof ApuBar);
        //"barObject instanceof ApuBar"
    }
}