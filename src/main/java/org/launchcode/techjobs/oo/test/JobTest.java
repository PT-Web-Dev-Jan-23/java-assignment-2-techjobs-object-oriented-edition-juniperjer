package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    //This is the Test the Empty Constructor
    @Test
    public void testSettingJobId(){
        Job testJob = new Job();
        Job testJob2 = new Job();
        assertNotEquals(testJob.getId(), testJob2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob3 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertTrue(testJob3 instanceof Job);
        assertTrue(testJob3.getEmployer() instanceof Employer);
        assertTrue(testJob3.getLocation() instanceof Location);
        assertTrue(testJob3.getPositionType() instanceof PositionType);
        assertTrue(testJob3.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", testJob3.getName());
        assertEquals("ACME", testJob3.getEmployer().getValue());
        assertEquals("Desert", testJob3.getLocation().getValue());
        assertEquals("Quality control", testJob3.getPositionType().getValue());
        assertEquals("Persistence", testJob3.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality(){
        Job testJob3 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job testJob4 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertFalse(testJob3 == testJob4);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job testJob = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        char arrayChar[] = testJob.toString().toCharArray();
        assertEquals('\n', arrayChar[arrayChar.length-1]);
        assertEquals('\n', arrayChar[0]);
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job testJob = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String labelsAndData= "\n" + "ID: " + testJob.getId() + "\n"+
                "Name: " + testJob.getName() + "\n" +
                "Employer: "+ testJob.getEmployer() + "\n"+
                "Location: "+ testJob.getLocation() + "\n"+
                "Position Type: " + testJob.getPositionType() + "\n"+
                "Core Competency: " + testJob.getCoreCompetency() + "\n";
        assertEquals(testJob.toString(), labelsAndData);
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job testJob = new Job("Product tester",
                new Employer("ACME"),
                new Location(""),
                new PositionType("Quality control"),
                new CoreCompetency(""));
        String labelsAndData= "\n" + "ID: " + testJob.getId() + "\n"+
                "Name: " + testJob.getName() + "\n" +
                "Employer: "+ testJob.getEmployer() + "\n"+
                "Location: "+ testJob.getLocation() + "\n"+
                "Position Type: " + testJob.getPositionType() + "\n"+
                "Core Competency: " + testJob.getCoreCompetency() + "\n";
        assertEquals(testJob.toString(), labelsAndData);
    }
}
