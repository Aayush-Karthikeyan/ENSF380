package edu.ucalgary.oop;

public class Car {
    private String model;
    private Driver driver;
    private Engine engine;

    // Public constructor: deep copy (safe)
    public Car(String model, Driver driver, Engine engine) {
        this(model, driver, engine, true);
    }

    // Private constructor: choose deep vs shallow
    private Car(String model, Driver driver, Engine engine, boolean deepCopy) {
        this.model = model;

        if (deepCopy) {
            this.driver = new Driver(driver);
            this.engine = new Engine(engine);
        } else {
            this.driver = driver;   // shallow: same object reference
            this.engine = engine;   // shallow: same object reference
        }
    }

    public Car copy(boolean deepCopy) {
        return new Car(this.model, this.driver, this.engine, deepCopy);
    }

    public String getModel() {
        return model;
    }

    public Driver getDriver() {
        return driver;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDriver(Driver driver) {
        this.driver = new Driver(driver);
    }

    public void setEngine(Engine engine) {
        this.engine = new Engine(engine);
    }
}
