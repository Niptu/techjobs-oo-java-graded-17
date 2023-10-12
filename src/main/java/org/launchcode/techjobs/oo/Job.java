package org.launchcode.techjobs.oo;

import java.sql.SQLOutput;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this(); // call the empty constructor to initialize 'id'
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }
// TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // Checks if the objects are the same.
        if (!(o instanceof Job)) return false;  // Checks if 'o' is an instance of Job.
        Job job = (Job) o;  // Cast 'o' to Job.
        return getId() == job.getId();  // Compares the IDs of this object and 'job'.
    }


    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
// Generate getter for 'id' field
    public int getId() {
        return id;
    }

    //adds new lines before and after each label and field value, ensuring that the string starts and ends with a blank line
//    @Override
//    public String toString(){
//        return System.lineSeparator()+"ID: " + id +
//                System.lineSeparator()+"Name: " + name +
//                System.lineSeparator()+"Employer; " + employer +
//                System.lineSeparator()+"Location: " + location +
//                System.lineSeparator()+"Position Type: " + positionType +
//                System.lineSeparator()+"Core Competency: " + coreCompetency +
//                System.lineSeparator();
//    }
    //modified toString method checks if a field is empty and, if so, adds "Data not available" for that field.
    // It also includes the "OOPS! This job does not seem to exist" message for a job with no data except the ID.
    @Override
    public String toString(){
        if (name.equals("") && employer.getValue().equals("") && location.getValue().equals("")
        && positionType.getValue().equals("") && coreCompetency.getValue().equals("")) {
            return System.lineSeparator() + "OOPS! This job does not seem to exist" + System.lineSeparator();
        }

        return System.lineSeparator()+"ID: " + id +
                System.lineSeparator()+"Name: " + (name.equals("") ? "Data not available" : name) +
                System.lineSeparator()+"Employer: " + (employer.getValue().equals("") ? "Data not available" : employer) +
                System.lineSeparator()+"Location: " + (location.getValue().equals("") ? "Data not available" : location) +
                System.lineSeparator()+"Position Type: " + (positionType.getValue().equals("") ? "Data not available" : positionType) +
                System.lineSeparator()+"Core Competency: " + (coreCompetency.getValue().equals("") ? "Data not available" : coreCompetency) +
                System.lineSeparator();
    }
}
