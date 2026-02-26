package edu.ucalgary.oop;

import java.time.LocalDate;

public class ReliefService {
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private LocalDate dateOfInquiry;
    private String infoProvided;
    private Location lastKnownLocation;

    public ReliefService(Inquirer inquirer, DisasterVictim missingPerson, LocalDate inquiryDate, String infoProvided,
            Location lastLocation) {
        this.inquirer = inquirer;
        this.missingPerson = missingPerson;
        setDateOfInquiry(inquiryDate);
        this.infoProvided = infoProvided;
        this.lastKnownLocation = lastLocation;
    }

    public Inquirer getInquirer() {
        return this.inquirer;
    }

    public void setInquirer(Inquirer inquirer) {
        this.inquirer = inquirer;
    }

    public DisasterVictim getMissingPerson() {
        return this.missingPerson;
    }

    public void setMissingPerson(DisasterVictim missingPerson) {
        this.missingPerson = missingPerson;
    }

    public LocalDate getDateOfInquiry() {
        return this.dateOfInquiry;
    }

    public void setDateOfInquiry(LocalDate inquiryDate) {
        if (inquiryDate == null) {
            throw new IllegalArgumentException("Date of inquiry cannot be null.");
        }
        if (inquiryDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date of inquiry cannot be in the future.");
        }
        this.dateOfInquiry = inquiryDate;
    }

    public String getInfoProvided() {
        return this.infoProvided;
    }

    public void setInfoProvided(String infoProvided) {
        this.infoProvided = infoProvided;
    }

    public Location getLastKnownLocation() {
        return this.lastKnownLocation;
    }

    public void setLastKnownLocation(Location lastLocation) {
        this.lastKnownLocation = lastLocation;
    }

    public String getLogDetails() {
        return "Inquirer: " + inquirer.getFirstName() +
                ", Missing Person: " + missingPerson.getFirstName() +
                ", Date of Inquiry: " + dateOfInquiry.toString() +
                ", Info Provided: " + infoProvided +
                ", Last Known Location: " + lastKnownLocation.getName();
    }
}
