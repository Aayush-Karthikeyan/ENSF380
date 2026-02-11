public class Car {
    // Atributes
    private String model;
    private Driver driver;
    private Engine engine;

    // Primary constructor
    public Car(String model, Driver driver, Engine engine) {
        this.model = model;

        // Deep copy
        this.driver = new Driver(driver);
        this.engine = new Engine(engine);
    }

    // Copy method
    public Car copy(boolean deepCopy) {

        if (deepCopy) {
            return new Car(
                this.model,
                new Driver(this.driver),
                new Engine(this.engine)
            );
        } 
        else {
            // shallow copy
            return new Car(
                this.model,
                this.driver,
                this.engine
            );
        }
    }
    // Getters
    public String getModel() {
        return model;
    }

    public Driver getDriver() {
        return driver;
    }

    public Engine getEngine() {
        return engine;
    }

    // Setters
    public void setModel(String model) {
        this.model = model;
    }

    public void setDriver(Driver driver) {
        this.driver = new Driver(driver); // keep deep copy safety
    }

    public void setEngine(Engine engine) {
        this.engine = new Engine(engine); // keep deep copy safety
    }
}