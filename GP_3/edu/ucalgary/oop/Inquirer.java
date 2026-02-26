package edu.ucalgary.oop;

public class Inquirer {
    private final String FIRST_NAME;
    private final String LAST_NAME;
    private final String INFO;
    private final String SERVICES_PHONE;

    public Inquirer(String firstName, String lastName, String phone, String info) {

        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty.");
        }

        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty.");
        }

        if (phone == null || phone.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone cannot be null or empty.");
        }

        if (info == null || info.trim().isEmpty()) {
            throw new IllegalArgumentException("Info cannot be null or empty.");
        }

        this.FIRST_NAME = firstName.trim();
        this.LAST_NAME = lastName.trim();
        this.SERVICES_PHONE = phone.trim();
        this.INFO = info.trim();
    }

    // Getters
    public String getFirstName() {
        return FIRST_NAME;
    }

    public String getLastName() {
        return LAST_NAME;
    }

    public String getServicesPhoneNum() {
        return SERVICES_PHONE;
    }

    public String getInfo() {
        return INFO;
    }
}