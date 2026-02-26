package edu.ucalgary.oop;

public class FamilyRelation {
    private DisasterVictim personOne;
    private String relationshipTo;
    private DisasterVictim personTwo;

    // Constructor
    public FamilyRelation(DisasterVictim personOne, String relationshipTo, DisasterVictim personTwo) {

        if (personOne == null) {
            throw new IllegalArgumentException("personOne cannot be null.");
        }

        if (personTwo == null) {
            throw new IllegalArgumentException("personTwo cannot be null.");
        }

        if (relationshipTo == null || relationshipTo.trim().isEmpty()) {
            throw new IllegalArgumentException("relationshipTo cannot be null or empty.");
        }

        this.personOne = personOne;
        this.relationshipTo = relationshipTo;
        this.personTwo = personTwo;
    }

    // Getters
    public DisasterVictim getPersonOne() { return personOne; }
    public String getRelationshipTo() { return relationshipTo; }
    public DisasterVictim getPersonTwo() { return personTwo; }

    // Setters
    public void setPersonOne(DisasterVictim personOne) {
        if (personOne == null) {
            throw new IllegalArgumentException("personOne cannot be null.");
        }
        this.personOne = personOne;
    }

    public void setRelationshipTo(String relationshipTo) {
        if (relationshipTo == null || relationshipTo.trim().isEmpty()) {
            throw new IllegalArgumentException("relationshipTo cannot be null or empty.");
        }
        this.relationshipTo = relationshipTo;
    }

    public void setPersonTwo(DisasterVictim personTwo) {
        if (personTwo == null) {
            throw new IllegalArgumentException("personTwo cannot be null.");
        }
        this.personTwo = personTwo;
    }
}
    
