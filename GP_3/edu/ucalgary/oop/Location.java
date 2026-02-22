package edu.ucalgary.oop;

public class Location {
    private String name;
    private String address;
    private DisasterVictim[] occupants;
    private Supply[] supplies;

    public Location(String name, String address) {
        this.name = name;
        this.address = address;
        this.occupants = new DisasterVictim[0];
        this.supplies = new Supply[0];
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DisasterVictim[] getOccupants() {
        return this.occupants;
    }

    public void setOccupants(DisasterVictim[] occupants) {
        this.occupants = occupants;
    }

    public Supply[] getSupplies() {
        return this.supplies;
    }

    public void setSupplies(Supply[] supplies) {
        this.supplies = supplies;
    }

    public void addOccupant(DisasterVictim occupant) {
        DisasterVictim[] newOccupants = new DisasterVictim[this.occupants.length + 1];
        for (int i = 0; i < this.occupants.length; i++) {
            newOccupants[i] = this.occupants[i];
        }
        newOccupants[this.occupants.length] = occupant;
        this.occupants = newOccupants;
    }

    public void removeOccupant(DisasterVictim occupant) {
        int index = -1;
        for (int i = 0; i < this.occupants.length; i++) {
            if (this.occupants[i] == occupant) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("Occupant not found in this location.");
        }
        DisasterVictim[] newOccupants = new DisasterVictim[this.occupants.length - 1];
        int j = 0;
        for (int i = 0; i < this.occupants.length; i++) {
            if (i != index) {
                newOccupants[j] = this.occupants[i];
                j++;
            }
        }
        this.occupants = newOccupants;
    }

    public void addSupply(Supply supply) {
        Supply[] newSupplies = new Supply[this.supplies.length + 1];
        for (int i = 0; i < this.supplies.length; i++) {
            newSupplies[i] = this.supplies[i];
        }
        newSupplies[this.supplies.length] = supply;
        this.supplies = newSupplies;
    }

    public void removeSupply(Supply supply) {
        int index = -1;
        for (int i = 0; i < this.supplies.length; i++) {
            if (this.supplies[i] == supply) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("Supply not found in this location.");
        }
        Supply[] newSupplies = new Supply[this.supplies.length - 1];
        int j = 0;
        for (int i = 0; i < this.supplies.length; i++) {
            if (i != index) {
                newSupplies[j] = this.supplies[i];
                j++;
            }
        }
        this.supplies = newSupplies;
    }
}
