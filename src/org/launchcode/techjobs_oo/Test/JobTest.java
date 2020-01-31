package org.launchcode.techjobs_oo.Test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.launchcode.techjobs_oo.*;

public class JobTest {
    Job test_job1;
    String name1 = "";
    Employer employer1 = new Employer("Alice");
    Location location1 = new Location("Savannah");
    PositionType positionType1 = new PositionType("Web-Dev");
    CoreCompetency coreCompetency1 = new CoreCompetency("JavaScript");

    Job test_job2;
    String name2 = "Data-Geek";
    Employer employer2 = new Employer("Noelle");
    Location location2 = new Location("Kansas City");
    PositionType positionType2 = new PositionType("Data Analyst");
    CoreCompetency coreCompetency2 = new CoreCompetency("SQL");

    Job test_job3;
    String name3 = "Data-Geek";
    Employer employer3 = new Employer("Noelle");
    Location location3 = new Location("Kansas City");
    PositionType positionType3 = new PositionType("Data Analyst");
    CoreCompetency coreCompetency3 = new CoreCompetency("SQL");


    @Before
        public void createJobObject() {
            test_job1 = new Job(name1, employer1, location1, positionType1, coreCompetency1);
            test_job2 = new Job(name2, employer2, location2, positionType2, coreCompetency2);
            test_job3 = new Job(name3, employer3, location3, positionType3, coreCompetency3);
        }


    @Test
    public void testSettingJobId() {
        assertNotEquals(test_job1.getId(), test_job2.getId());
        assertTrue(Math.abs(test_job1.getId() - test_job2.getId()) >= 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(test_job1.getEmployer() instanceof Employer);
        assertEquals(job.getEmployer().getValue(), "ACME");
        assertEquals(job.getName(), "Product tester");
        assertEquals(job.getPositionType().getValue(), "Quality control");
        assertEquals(job.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        assertNotEquals(test_job2, test_job3);
    }

    @Test
    public void testToStringBlankLines() {
        assertTrue(test_job1.toString().startsWith("\n"));
        assertTrue(test_job1.toString().endsWith("\n"));
    }

    @Test
    public void testLabelsAndLines() {
        String expected = "\nID:  " + test_job1.getId() + "\nName:  " + test_job1.getName() + "\nEmployer:  " + test_job1.getEmployer() + "\nLocation:  " + test_job1.getLocation() + "\nPosition Type:  " + test_job1.getPositionType() + "\nCore Competency:  " + test_job1.getCoreCompetency() + "\n";
        assertEquals(test_job1.toString(), expected);
    }

    @Test
    public void testBlankField() {
        if (test_job1.getName() == null) {
            String expected = "\nID: " + test_job1.getId() + "\nName:  " + "Data not available" + "\nEmployer:  " + test_job1.getEmployer() + "\nLocation:  " + test_job1.getLocation() + "\nPosition Type:  " + test_job1.getPositionType() + "\nCore Competency:  " + test_job1.getCoreCompetency() + "\n";
            assertEquals(test_job1.toString(), expected);
        }
        if (test_job1.getEmployer() == null) {
            String expected = "\nID:  " + test_job1.getId() + "\nName:  " + test_job1.getName() + "\nEmployer:  " + "Data not available" + "\nLocation:  " + test_job1.getLocation() + "\nPosition Type:  " + test_job1.getPositionType() + "\nCore Competency:  " + test_job1.getCoreCompetency() + "\n";
            assertEquals(test_job1.toString(), expected);
        }
    }

    @Test
    public void ifJobInfoIsBlank() {
        if (test_job1 == null) {
            String expected = "OOPS! This job does not seem to exist.";
            assertEquals(test_job1.toString(), expected);

        }
    }
}

