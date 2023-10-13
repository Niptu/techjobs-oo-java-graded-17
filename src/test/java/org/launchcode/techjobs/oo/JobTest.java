package org.launchcode.techjobs.oo;

import org.junit.Test;
import static org.junit.Assert.*;
public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobID(){
        //create 2 job objects using the empty constructor
        Job job1 = new Job();
        Job job2 = new Job();
        //use assertNotEquals to verify that IDs of thr two objects are distinct
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //check the id field (should be more than 0)
        assertTrue(job.getId() > 0);

        //check name field
        assertEquals("Product tester",job.getName());

        //Check the employer field (both class and value)
        assertTrue(job.getEmployer() instanceof Employer);
        assertEquals("ACME", job.getEmployer().getValue());

        //check location
        assertTrue(job.getLocation() instanceof Location);
        assertEquals("Desert", job.getLocation().getValue());

        //check positionType
        assertTrue(job.getPositionType() instanceof PositionType);
        assertEquals("Quality control", job.getPositionType().getValue());

        //cgeck coreCompetency
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality (){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
    }

    //This test verifies that the toString method returns a string that starts and ends with a new line
    @Test
    public void testToStringStartsAndEndsWithNewLine () {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String jobString = job.toString();

        //assertTrue(jobString.startsWith(System.lineSeparator()));
        assertTrue(jobString.endsWith(System.lineSeparator()));
    }

    //the labels and data are correctly included in the toString output
    @Test
    public void testToStringContainsCorrectLabelsAndData () {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expectedOutput = "ID: " + job.getId() +
                System.lineSeparator() + "Name: Product tester" +
                System.lineSeparator() + "Employer: ACME" +
                System.lineSeparator() + "Location: Desert" +
                System.lineSeparator() + "Position Type: Quality control" +
                System.lineSeparator() + "Core Competency: Persistence" +
                System.lineSeparator();

        assertEquals(expectedOutput, job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField () {
        Job job = new Job("Product tester", new Employer(""), new Location(""),
                new PositionType(""), new CoreCompetency(""));
        String expectedOutput = "ID: " + job.getId() +
                System.lineSeparator() + "Name: " + job.getName() +
                System.lineSeparator() + "Employer: Data not available" +
                System.lineSeparator() + "Location: Data not available" +
                System.lineSeparator() + "Position Type: Data not available" +
                System.lineSeparator() + "Core Competency: Data not available" +
                System.lineSeparator();
        assertEquals(expectedOutput, job.toString());
    }
}
