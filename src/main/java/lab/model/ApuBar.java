package lab.model;

import lab.aop.Polite;
import org.springframework.stereotype.Component;

@Component
public class ApuBar implements Bar {

    @Polite
	public Squishee sellSquishee(Person customer)  {
        if (customer.isBroke())
            throw new CustomerBrokenException();

        System.out.println("Here is your Squishee");
        return new Squishee("Usual Squishee");
    }
}