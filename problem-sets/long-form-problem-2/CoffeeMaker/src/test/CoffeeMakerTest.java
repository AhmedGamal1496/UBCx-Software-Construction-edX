package test;

import model.CoffeeMaker;
import model.exceptions.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class CoffeeMakerTest {
    private CoffeeMaker maker;

    @Before
    public void setUp(){
        maker = new CoffeeMaker();
    }

    @Test
    public void testGetters() throws BeansAmountException, WaterException {
        assertEquals(maker.getTimeSinceLastBrew(), maker.getCupsRemaining(), 0);
        successfulBrew();
        assertEquals(maker.getCupsRemaining(), 20);
    }

    @Test
    public void testSetters() {
        maker.setTimeSinceLastBrew(30);
        assertEquals(maker.getTimeSinceLastBrew(), 30);
    }

    @Test (expected = TooManyBeansException.class)
    public void testBrewTooManyBeans() throws BeansAmountException, WaterException {
        maker.brew(2.7, 14);
    }

    @Test (expected = NotEnoughBeansException.class)
    public void testBrewNotEnoughBeans() throws BeansAmountException, WaterException {
        maker.brew(2.3, 13);
    }

    @Test (expected = WaterException.class)
    public void testBrewNotEnoughWater() throws BeansAmountException, WaterException {
        maker.brew(2.5, 13);
    }

    @Test
    public void testBrewShouldPass() throws BeansAmountException, WaterException {
        try {
            maker.brew(2.40, 14.8);
            maker.brew(2.60, 14.76);
        }
        catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testPourCoffeeShouldPass() {
        try {
            successfulBrew();
            pour20Cups();
        }
        catch (Exception e) {
            fail();
        }
    }

    @Test (expected = NoCupsRemainingException.class)
    public void testPourCoffeeNoCupsRemaining() throws BeansAmountException, WaterException, StaleCoffeeException, NoCupsRemainingException {
        successfulBrew();
        pour20Cups();
        maker.pourCoffee();
    }

    @Test (expected = StaleCoffeeException.class)
    public void testPourCoffeeStaleCoffee() throws BeansAmountException, WaterException, NoCupsRemainingException, StaleCoffeeException {
        successfulBrew();
        maker.setTimeSinceLastBrew(60);
        maker.pourCoffee();
    }

    private void successfulBrew() throws BeansAmountException, WaterException {
        maker.brew(2.5, 15);
    }

    private void pour20Cups() throws StaleCoffeeException, NoCupsRemainingException {
        for(int i=0; i<20; i++){
            maker.pourCoffee();
        }
    }

}
