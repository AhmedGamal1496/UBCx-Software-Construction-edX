package tests;

import model.Transcript;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TranscriptTest {

    private Transcript testTranscript;
    private static final float TOL = 1.000f;

    @Before
    public void setUp(){
        testTranscript = new Transcript("Jimbo", 1000);
        //TODO: write new values in testTranscript constructor
    }

    //TODO: write tests for Transcript methods

    @Test
    public void testConstructor(){
        assertEquals(testTranscript.getStudentName(), "Jimbo");
        assertEquals(testTranscript.getStudentID(), 1000);
        assertEquals(testTranscript.getStudentGrades().size(), 0);
        assertEquals(testTranscript.getStudentCourses().size(), 0);
    }

    @Test
    public void testSetters() {
        testTranscript.setStudentName("Ahmed");
        testTranscript.setStudentID(5362);
        assertEquals(testTranscript.getStudentName(), "Ahmed");
        assertEquals(testTranscript.getStudentID(), 5362);
    }

    @Test
    public void testAddCourse() {
        assertEquals(testTranscript.getStudentCourses().size(), 0);
        testTranscript.addCourse("CSE", 2.05);
        assertEquals(testTranscript.getStudentGrades().size(), 1);
        assertEquals(testTranscript.getStudentGrades().size(),
                testTranscript.getStudentCourses().size());
        loadGrades();
        assertEquals(testTranscript.getStudentGrades().size(),
                testTranscript.getStudentCourses().size());
    }

    @Test
    public void testGetCourseAndGrade() {
        loadGrades();
        assertEquals(testTranscript.getCourseAndGrade("HtC"), "HtC: 3.0");
        assertEquals(testTranscript.getCourseAndGrade("ENG"), "ENG: 4.0");
    }

    @Test
    public void testGetGPA() {
        loadGrades();
        assertEquals(testTranscript.getGPA(testTranscript.getStudentGrades()), 3.5, 3.50);
        testTranscript.addCourse("PHY", 2.5);
        double avg = (3.0 + 4.0 + 2.5) / 3;
        assertEquals(testTranscript.getGPA(testTranscript.getStudentGrades()), avg, TOL);
    }

    @Test
    public void testGetGradeByCourse() {
        loadGrades();
        double grade1 = testTranscript.getGradeByCourse("HtC");
        assertEquals(grade1, 3.0, TOL);
        double grade2 = testTranscript.getGradeByCourse("ENG");
        assertEquals(grade1, 4.0, TOL);
    }

    @Test
    public void testGetAverageOverSelectedCourses() {
        double avg1 = testTranscript.getAverageOverSelectedCourses(testTranscript.getStudentCourses());
        assertEquals(avg1, 0, TOL);
        loadGrades();
        double avg2 = testTranscript.getAverageOverSelectedCourses(testTranscript.getStudentCourses());
        assertEquals(avg2, (3.0 + 4.0) / 2, TOL);
        testTranscript.addCourse("FCG", 3.3);
        double avg3 = testTranscript.getAverageOverSelectedCourses(testTranscript.getStudentCourses());
        assertEquals(avg3, (3.0 + 4.0 + 3.3) / 3, TOL);
    }

    private void loadGrades() {
        testTranscript.addCourse("HtC", 3.0);
        testTranscript.addCourse("ENG", 4.0);
    }

}

