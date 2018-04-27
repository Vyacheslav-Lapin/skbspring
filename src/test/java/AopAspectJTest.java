import lab.JavaConfig;
import lab.aop.AopLog;
import lab.model.ApuBar;
import lab.model.Bar;
import lab.model.Customer;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@ExtendWith(SpringExtension.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
@ContextConfiguration(classes = JavaConfig.class)
@FieldDefaults(level = PRIVATE)
class AopAspectJTest {

    Bar bar;
    
	Customer customer;

    @BeforeEach
    void setUp() throws Exception {
    	
        bar.sellSquishee(customer);
    }

    @Test
    void testBeforeAdvice() {
        assertTrue("Before advice is not good enought...", AopLog.getStringValue().contains("Hello"));
        assertTrue("Before advice is not good enought...", AopLog.getStringValue().contains("How are you doing?"));
        System.out.println(AopLog.getStringValue());
    }

    @Test
    public void testAfterAdvice() {
        System.out.println(AopLog.getStringValue());
        assertTrue("After advice is not good enought...", AopLog.getStringValue().contains("Good Bye!"));
    }

    @Test
    void testAfterReturningAdvice() {
        assertTrue("Customer is broken", AopLog.getStringValue().contains("Good Enough?"));
        System.out.println(AopLog.getStringValue());
    }

    @Test
    void testAroundAdvice() {
        assertTrue("Around advice is not good enought...", AopLog.getStringValue().contains("Hi!"));
        assertTrue("Around advice is not good enought...", AopLog.getStringValue().contains("See you!"));
        System.out.println(AopLog.getStringValue());
    }

    @Test
    void testAllAdvices() {
        assertFalse(bar instanceof ApuBar); //"barObject instanceof ApuBar"
    }
}