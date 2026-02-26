package edu.ucalgary.oop;

import java.time.LocalDate;

public class DisasterVictim {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private FamilyRelation[] familyConnections;
    private MedicalRecord[] medicalRecords;
    private Supply[] personalBelongings;
    private LocalDate ENTRY_DATE;
    private String gender;
    private String comments;

    // Constructors
    public DisasterVictim(String firstName, LocalDate entryDate) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("firstName cannot be null/empty.");
        }
        if (entryDate == null) {
            throw new IllegalArgumentException("entryDate cannot be null.");
        }

        this.firstName = firstName;
        this.ENTRY_DATE = entryDate;

        // initialize arrays to avoid null issues
        this.familyConnections = new FamilyRelation[0];
        this.medicalRecords = new MedicalRecord[0];
        this.personalBelongings = new Supply[0];
    }

    public DisasterVictim(String firstName, LocalDate entryDate, LocalDate dateOfBirth) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("firstName cannot be null/empty.");
        }
        if (entryDate == null) {
            throw new IllegalArgumentException("entryDate cannot be null.");
        }
        if (dateOfBirth == null) {
            throw new IllegalArgumentException("dateOfBirth cannot be null.");
        }
        if (dateOfBirth.isAfter(entryDate)) {
            throw new IllegalArgumentException("dateOfBirth cannot be after entryDate.");
        }

        this.firstName = firstName;
        this.ENTRY_DATE = entryDate;
        this.dateOfBirth = dateOfBirth;

        this.familyConnections = new FamilyRelation[0];
        this.medicalRecords = new MedicalRecord[0];
        this.personalBelongings = new Supply[0];
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public FamilyRelation[] getFamilyConnections() {
        return familyConnections;
    }

    public MedicalRecord[] getMedicalRecords() {
        return medicalRecords;
    }

    public Supply[] getPersonalBelongings() {
        return personalBelongings;
    }

    public LocalDate getEntryDate() {
        return ENTRY_DATE;
    }

    public String getComments() {
        return comments;
    }

    public String getGender() {
        return gender;
    }

    // Setters
    public void setFirstName(String newFirstName) {
        if (newFirstName == null || newFirstName.trim().isEmpty()) {
            throw new IllegalArgumentException("firstName cannot be null/empty.");
        }
        this.firstName = newFirstName;
    }

    public void setLastName(String newLastName) {

        this.lastName = newLastName;
    }

    public void setDateOfBirth(LocalDate newDateOfBirth) {
        if (newDateOfBirth == null) {
            throw new IllegalArgumentException("dateOfBirth cannot be null.");
        }
        if (ENTRY_DATE != null && newDateOfBirth.isAfter(ENTRY_DATE)) {
            throw new IllegalArgumentException("dateOfBirth cannot be after entryDate.");
        }
        this.dateOfBirth = newDateOfBirth;
    }

    public void setFamilyConnections(FamilyRelation[] newFamilyConnections) {
        if (newFamilyConnections == null) {
            throw new IllegalArgumentException("familyConnections cannot be null.");
        }
        this.familyConnections = newFamilyConnections;
    }

    public void setMedicalRecords(MedicalRecord[] newMedicalRecords) {
        if (newMedicalRecords == null) {
            throw new IllegalArgumentException("medicalRecords cannot be null.");
        }
        this.medicalRecords = newMedicalRecords;
    }

    public void setPersonalBelongings(Supply[] newPersonalBelongings) {
        if (newPersonalBelongings == null) {
            throw new IllegalArgumentException("personalBelongings cannot be null.");
        }
        this.personalBelongings = newPersonalBelongings;
    }

    public void setGender(String gender) {
        if (gender == null || gender.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid gender option.");
        }

        String raw = gender.trim();

        // Step 1: detect "please specify" (case-insensitive, whitespace-insensitive)
        String normalizedKey = raw.toLowerCase().replaceAll("\\s+", " ");
        if (normalizedKey.equals("please specify")) {
            this.gender = "Please Specify";
            return;
        }

        // Step 2: if previously set to "Please Specify", allow any non-empty value
        if (this.gender != null && this.gender.equals("Please Specify")) {
            this.gender = raw;
            return;
        }

        // Step 3: otherwise enforce the restricted options
        String g = raw.toLowerCase();

        String normalized;
        if (g.equals("man")) {
            normalized = "Man";
        } else if (g.equals("woman")) {
            normalized = "Woman";
        } else if (g.equals("boy")) {
            normalized = "Boy";
        } else if (g.equals("girl")) {
            normalized = "Girl";
        } else {
            throw new IllegalArgumentException("Invalid gender option.");
        }

        // Step 4: enforce child/adult rules if DOB is known
        if (this.dateOfBirth != null) {
            LocalDate ref = (this.ENTRY_DATE != null) ? this.ENTRY_DATE : LocalDate.now();

            int age = ref.getYear() - this.dateOfBirth.getYear();
            if (ref.getMonthValue() < this.dateOfBirth.getMonthValue()
                    || (ref.getMonthValue() == this.dateOfBirth.getMonthValue()
                            && ref.getDayOfMonth() < this.dateOfBirth.getDayOfMonth())) {
                age--;
            }

            boolean isChild = age < 18;

            if (isChild && (normalized.equals("Man") || normalized.equals("Woman"))) {
                throw new IllegalArgumentException("Invalid gender option.");
            }
            if (!isChild && (normalized.equals("Boy") || normalized.equals("Girl"))) {
                throw new IllegalArgumentException("Invalid gender option.");
            }
        }

        this.gender = normalized;
    }

    public void setComments(String newComments) {
        this.comments = newComments;
    }

    // Add methods

    public void addPersonalBelonging(Supply belonging) {
        if (belonging == null) {
            throw new IllegalArgumentException("belonging cannot be null.");
        }
        if (personalBelongings == null) {
            personalBelongings = new Supply[0];
        }

        Supply[] newTemp = new Supply[personalBelongings.length + 1];
        for (int i = 0; i < personalBelongings.length; i++) {
            newTemp[i] = personalBelongings[i];
        }
        newTemp[newTemp.length - 1] = belonging;
        personalBelongings = newTemp;
    }

    public void addFamilyConnection(FamilyRelation connection) {
        if (connection == null) {
            throw new IllegalArgumentException("connection cannot be null.");
        }
        if (familyConnections == null) {
            familyConnections = new FamilyRelation[0];
        }

        FamilyRelation[] newTemp = new FamilyRelation[familyConnections.length + 1];
        for (int i = 0; i < familyConnections.length; i++) {
            newTemp[i] = familyConnections[i];
        }
        newTemp[newTemp.length - 1] = connection;
        familyConnections = newTemp;
    }

    public void addMedicalRecord(MedicalRecord record) {
        if (record == null) {
            throw new IllegalArgumentException("record cannot be null.");
        }
        if (medicalRecords == null) {
            medicalRecords = new MedicalRecord[0];
        }

        MedicalRecord[] newTemp = new MedicalRecord[medicalRecords.length + 1];
        for (int i = 0; i < medicalRecords.length; i++) {
            newTemp[i] = medicalRecords[i];
        }
        newTemp[newTemp.length - 1] = record;
        medicalRecords = newTemp;
    }

    // Remove methods

    public void removePersonalBelonging(Supply belonging) {
        if (belonging == null) {
            throw new IllegalArgumentException("Belonging cannot be null.");
        }
        if (personalBelongings == null || personalBelongings.length == 0) {
            throw new IllegalArgumentException("Belonging not found.");
        }

        int count = 0;
        boolean found = false;

        for (int i = 0; i < personalBelongings.length; i++) {
            if (personalBelongings[i] == belonging) {
                found = true;
            } else {
                count++;
            }
        }

        if (!found) {
            throw new IllegalArgumentException("Belonging not found.");
        }

        Supply[] newTemp = new Supply[count];
        int j = 0;
        for (int i = 0; i < personalBelongings.length; i++) {
            if (personalBelongings[i] != belonging) {
                newTemp[j] = personalBelongings[i];
                j++;
            }
        }

        personalBelongings = newTemp;
    }

    public void removeFamilyConnection(FamilyRelation connection) {
        if (connection == null) {
            throw new IllegalArgumentException("connection cannot be null.");
        }
        if (familyConnections == null || familyConnections.length == 0) {
            return;
        }

        int count = 0;
        for (int i = 0; i < familyConnections.length; i++) {
            if (familyConnections[i] != connection) {
                count++;
            }
        }

        if (count == familyConnections.length) {
            return;
        }

        FamilyRelation[] newTemp = new FamilyRelation[count];
        int j = 0;
        for (int i = 0; i < familyConnections.length; i++) {
            if (familyConnections[i] != connection) {
                newTemp[j] = familyConnections[i];
                j++;
            }
        }

        familyConnections = newTemp;
    }

}