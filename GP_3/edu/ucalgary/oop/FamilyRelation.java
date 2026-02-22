package edu.ucalgary.oop;

public class FamilyRelation {
    private DisasterVictim personOne;
    private String relationshipTo;
    private DisasterVictim personTwo;

    public FamilyRelation(DisasterVictim personOne, String relationshipTo, DisasterVictim personTwo) {
        setPersonOne(personOne);
        setRelationshipTo(relationshipTo);
        setPersonTwo(personTwo);
    }

    public DisasterVictim getPersonOne() {
        return this.personOne;
    }

    public void setPersonOne(DisasterVictim personOne) {
        if (personOne == null) {
            throw new IllegalArgumentException("Person one cannot be null.");
        }
        this.personOne = personOne;
    }

    public String getRelationshipTo() {
        return this.relationshipTo;
    }

    public void setRelationshipTo(String relationshipTo) {
        this.relationshipTo = relationshipTo;
    }

    public DisasterVictim getPersonTwo() {
        return this.personTwo;
    }

    public void setPersonTwo(DisasterVictim personTwo) {
        if (personTwo == null) {
            throw new IllegalArgumentException("Person two cannot be null.");
        }
        this.personTwo = personTwo;
    }
}
