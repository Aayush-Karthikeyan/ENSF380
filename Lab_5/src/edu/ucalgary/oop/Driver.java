package edu.ucalgary.oop;

public class Driver {
    private String name;

    public Driver(String name){
        this.name = name;
    }
    
    public Driver(Driver other) {
        if (other == null) {
            throw new IllegalArgumentException("other Driver cannot be null");
        }
        this.name = other.name;
    }

    // + getName(): String
    public String getName() {
        return name;
    }

    // + setName(name: String)
    public void setName(String name) {
        this.name = name;
    }
}
