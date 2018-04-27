package lab.aop;

import lab.model.Person;
import lab.model.Squishee;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Politeness {

    @Pointcut("@annotation(Polite)")
    private void polite() {
    }

    @Before("polite() && args(person)")
    public void sayHello(Person person) {
        System.out.printf("Hello %s. How are you doing?%n",
                person.getName());
    }

    @AfterReturning(pointcut = "polite()",
                    returning = "result",
                    argNames = "result")
    public void askOpinion(Squishee result) {
        System.out.printf("Is %s Good Enough?%n",
                result.getName());
    }

    @AfterThrowing("polite()")
    public void sayYouAreNotAllowed() {
        System.out.println("Hmmm...");
    }

    @After("polite()")
    public void sayGoodBye() {
        System.out.println("Good Bye!");
    }

    @Around("polite()")
    public Object sayPoliteWordsAndSell(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Hi!");
        Object retVal = pjp.proceed();
        System.out.println("See you!");
        return retVal;
    }

}