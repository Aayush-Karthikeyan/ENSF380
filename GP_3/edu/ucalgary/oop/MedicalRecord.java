package edu.ucalgary.oop;

import java.time.LocalDate;

public class MedicalRecord {
    private Location location;
    private String treatmentDetails;
    private LocalDate dateOfTreatment;

    public MedicalRecord(Location location, String treatmentDetails, LocalDate dateOfTreatment) {
        setLocation(location);
        setTreatmentDetails(treatmentDetails);
        setDateOfTreatment(dateOfTreatment);
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTreatmentDetails() {
        return this.treatmentDetails;
    }

    public void setTreatmentDetails(String treatmentDetails) {
        this.treatmentDetails = treatmentDetails;
    }

    public LocalDate getDateOfTreatment() {
        return this.dateOfTreatment;
    }

    public void setDateOfTreatment(LocalDate dateOfTreatment) {
        if (dateOfTreatment == null) {
            throw new IllegalArgumentException("Date of treatment cannot be null.");
        }
        if (dateOfTreatment.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date of treatment cannot be in the future.");
        }
        this.dateOfTreatment = dateOfTreatment;
    }
}
