package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void testDeepCopyDriver() {
        Driver originalDriver = new Driver("Alice");
        Driver copiedDriver = new Driver(originalDriver); // Deep copy of Driver

        // Ensure the name is the same
        assertEquals("Name of driver was changed between copy and original",
          originalDriver.getName(), copiedDriver.getName());

        // Ensure it was a deep copy
        assertFalse("Copied driver must be a deep not shallow copy",
          originalDriver == copiedDriver);
    }

    @Test
    public void testDeepCopyEngine() {
        Engine originalEngine = new Engine("V6");
        Engine copiedEngine = new Engine(originalEngine); // Deep copy of Engine

        // Ensure the engine type is the same
        assertEquals("Engine type was changed between copy and original",
          originalEngine.getEngineType(), copiedEngine.getEngineType());

        // Ensure it was a deep copy
        assertFalse("Copied engine must be a deep not shallow copy",
          originalEngine == copiedEngine);
    }

    @Test
    public void testDeepCopyCar() {
        Driver driver = new Driver("Alice");
        Engine engine = new Engine("V6");
        Car originalCar = new Car("Tesla Model X", driver, engine);

        // Giving "true" to the copy method creates a deep copy
        Car deepCopyCar = originalCar.copy(true); 

        // Ensure copied car has the same values
        assertEquals("Car should have same values after copy",
            originalCar.getModel(), deepCopyCar.getModel());
        assertEquals("Driver should have same values after copy",
            originalCar.getDriver().getName(), deepCopyCar.getDriver().getName());
        assertEquals("Engine should have same values after copy",
            originalCar.getEngine().getEngineType(), 
            deepCopyCar.getEngine().getEngineType());

        // Ensure a deep copy was made
        assertFalse("Copied car must be a deep not shallow copy",
            originalCar == deepCopyCar);
        assertFalse("Copied driver must be a deep not shallow copy",
            originalCar.getDriver() == deepCopyCar.getDriver());
        assertFalse("Copied engine must be a deep not shallow copy",
            originalCar.getEngine() == deepCopyCar.getEngine());
    }

    @Test
    public void testShallowCopyCar() {
        Driver driver = new Driver("Alice");
        Engine engine = new Engine("V6");
        Car originalCar = new Car("Tesla Model X", driver, engine);

        // Giving "false" to the copy method creates a shallow copy
        Car shallowCopyCar = originalCar.copy(false); 

        // Ensure a shallow copy was made
        assertEquals("Copied car must be a shallow copy",
           originalCar.getModel(), shallowCopyCar.getModel());
        assertEquals("Copied driver must be a shallow copy",
           originalCar.getDriver(), shallowCopyCar.getDriver());
        assertEquals("Copied driver must be a shallow copy",
           originalCar.getEngine(), shallowCopyCar.getEngine());
    }
}
