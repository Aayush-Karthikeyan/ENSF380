package edu.ucalgary.oop;

import java.time.LocalDate;
import java.time.Period;

public class DisasterVictim {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private FamilyRelation[] familyConnections;
    private MedicalRecord[] medicalRecords;
    private Supply[] personalBelongings;
    private final LocalDate ENTRY_DATE;
    private String gender;
    private String comments;
    private boolean pleaseSpecifyMode = false;

    public DisasterVictim(String firstName, LocalDate entryDate) {
        this.firstName = firstName;
        this.ENTRY_DATE = entryDate;
        this.familyConnections = new FamilyRelation[0];
        this.medicalRecords = new MedicalRecord[0];
        this.personalBelongings = new Supply[0];
    }

    public DisasterVictim(String firstName, LocalDate entryDate, LocalDate dateOfBirth) {
        this(firstName, entryDate);
        setDateOfBirth(dateOfBirth);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth != null && dateOfBirth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date of birth cannot be in the future.");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        if (gender == null) {
            throw new IllegalArgumentException("Gender cannot be null.");
        }

        // If we're in "please specify" mode, accept any free-form text
        if (this.pleaseSpecifyMode) {
            this.gender = gender;
            this.pleaseSpecifyMode = false;
            return;
        }

        String lowerGender = gender.toLowerCase();

        // Check if it's the "please specify" option
        if (lowerGender.equals("please specify")) {
            this.pleaseSpecifyMode = true;
            return;
        }

        // Normalize to proper case for comparison
        String normalized = lowerGender.substring(0, 1).toUpperCase() + lowerGender.substring(1);

        // Validate against allowed options with age checks
        if (normalized.equals("Man") || normalized.equals("Woman")) {
            // Must be 18 or older
            if (this.dateOfBirth == null) {
                throw new IllegalArgumentException("Date of birth must be set to use Man/Woman.");
            }
            int age = Period.between(this.dateOfBirth, LocalDate.now()).getYears();
            if (age < 18) {
                throw new IllegalArgumentException(normalized + " is only valid for adults (18+).");
            }
            this.gender = normalized;
        } else if (normalized.equals("Boy") || normalized.equals("Girl")) {
            // Must be under 18
            if (this.dateOfBirth == null) {
                throw new IllegalArgumentException("Date of birth must be set to use Boy/Girl.");
            }
            int age = Period.between(this.dateOfBirth, LocalDate.now()).getYears();
            if (age >= 18) {
                throw new IllegalArgumentException(normalized + " is only valid for children (under 18).");
            }
            this.gender = normalized;
        } else {
            throw new IllegalArgumentException("Invalid gender option: " + gender);
        }
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDate getEntryDate() {
        return this.ENTRY_DATE;
    }

    public FamilyRelation[] getFamilyConnections() {
        return this.familyConnections;
    }

    public void setFamilyConnections(FamilyRelation[] connections) {
        this.familyConnections = connections;
    }

    public MedicalRecord[] getMedicalRecords() {
        return this.medicalRecords;
    }

    public void setMedicalRecords(MedicalRecord[] records) {
        this.medicalRecords = records;
    }

    public Supply[] getPersonalBelongings() {
        return this.personalBelongings;
    }

    public void setPersonalBelongings(Supply[] supplies) {
        this.personalBelongings = supplies;
    }

    public void addPersonalBelonging(Supply belonging) {
        Supply[] newBelongings = new Supply[this.personalBelongings.length + 1];
        for (int i = 0; i < this.personalBelongings.length; i++) {
            newBelongings[i] = this.personalBelongings[i];
        }
        newBelongings[this.personalBelongings.length] = belonging;
        this.personalBelongings = newBelongings;
    }

    public void removePersonalBelonging(Supply belonging) {
        int index = -1;
        for (int i = 0; i < this.personalBelongings.length; i++) {
            if (this.personalBelongings[i] == belonging) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("Personal belonging not found.");
        }
        Supply[] newBelongings = new Supply[this.personalBelongings.length - 1];
        int j = 0;
        for (int i = 0; i < this.personalBelongings.length; i++) {
            if (i != index) {
                newBelongings[j] = this.personalBelongings[i];
                j++;
            }
        }
        this.personalBelongings = newBelongings;
    }

    public void addFamilyConnection(FamilyRelation connection) {
        FamilyRelation[] newConnections = new FamilyRelation[this.familyConnections.length + 1];
        for (int i = 0; i < this.familyConnections.length; i++) {
            newConnections[i] = this.familyConnections[i];
        }
        newConnections[this.familyConnections.length] = connection;
        this.familyConnections = newConnections;
    }

    public void removeFamilyConnection(FamilyRelation connection) {
        int index = -1;
        for (int i = 0; i < this.familyConnections.length; i++) {
            if (this.familyConnections[i] == connection) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("Family connection not found.");
        }
        FamilyRelation[] newConnections = new FamilyRelation[this.familyConnections.length - 1];
        int j = 0;
        for (int i = 0; i < this.familyConnections.length; i++) {
            if (i != index) {
                newConnections[j] = this.familyConnections[i];
                j++;
            }
        }
        this.familyConnections = newConnections;
    }

    public void addMedicalRecord(MedicalRecord record) {
        MedicalRecord[] newRecords = new MedicalRecord[this.medicalRecords.length + 1];
        for (int i = 0; i < this.medicalRecords.length; i++) {
            newRecords[i] = this.medicalRecords[i];
        }
        newRecords[this.medicalRecords.length] = record;
        this.medicalRecords = newRecords;
    }
}
