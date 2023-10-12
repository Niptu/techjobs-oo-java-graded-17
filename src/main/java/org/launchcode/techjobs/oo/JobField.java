package org.launchcode.techjobs.oo;

import java.util.Objects;

// Declare the common fields id and value.
// Provide two constructors to initialize these fields.
// Generate the getters and setters for id and value.
// Include a toString method to handle the case where the value is missing or empty, providing "Data not available."
// Equals and hashCode methods based on the id field.
//        We mark the class as abstract to prevent direct instantiation, ensuring that it's only used as a base class for other classes.
public class JobField {
    private int id;
    private static int nextId =1;
    private String value;

    public JobField() {
        this.id = nextId;
        nextId++;
    }
    public JobField(String value) {
        this();
        this.value = value;
    }
    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if (this.value == null || this.value.isEmpty()) {
            return "Data not available";
        }
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // Checks if the objects are the same.
        if (!(o instanceof Job)) return false;  // Checks if 'o' is an instance of Job.
        Job job = (Job) o;  // Cast 'o' to Job.
        return getId() == job.getId();  // Compares the IDs of this object and 'job'.
    }


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
