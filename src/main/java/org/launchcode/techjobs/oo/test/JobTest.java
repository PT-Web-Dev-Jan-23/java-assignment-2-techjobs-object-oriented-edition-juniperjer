package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
        assertEquals("Product tester", testJob3.getName());

        assertTrue(testJob3.getEmployer() instanceof Employer);
        assertEquals("ACME", testJob3.getEmployer().getValue());

        assertTrue(testJob3.getLocation() instanceof Location);
        assertEquals("Desert", testJob3.getLocation().getValue());

        assertTrue(testJob3.getPositionType() instanceof PositionType);
        assertEquals("Quality control", testJob3.getPositionType().getValue());

        assertTrue(testJob3.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", testJob3.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality(){
        Job testJob3 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job testJob4 = new Job("Humphrey",
                new Employer("LaunchCode"),
                new Location("Jungle"),
                new PositionType("CEO"),
                new CoreCompetency("Personality Hire"));
        assertNotEquals(testJob3, testJob4);
    }
}
