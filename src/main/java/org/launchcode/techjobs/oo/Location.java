package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Location {

    private int id;
    private static int nextId = 1;
    private String value;

    public Location() {
        id = nextId;
        nextId++;
    }

    // TODO: Add a constructor that takes a string as a parameter and assigns it to the 'value' field. The
    //  constructor should also call the empty constructor in order to initialize the 'id' field.

    //constructor with a parameter (similar like Employer)
    public Location (String value) {
        this(); //call the empty constructor to initialize the 'ID' field
        this.value = value; //set the 'value' field to the provided value
    }
// Custom toString, equals, and hashCode methods:

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return getId() == location.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // Getters and Setters:

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
