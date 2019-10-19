package model;

import java.util.ArrayList;
import java.util.List;

/**
 * INVARIANT: course list and grade list are the same size
 * each course has a grade associated, and vice versa, at matching indices
 */

public class Transcript {

    private String name;
    private int id;
    private List<String> courses;
    private List<Double> grades;

    public Transcript(String name, int id) {
        this.name = name;
        this.id = id;
        courses = new ArrayList<>();
        grades = new ArrayList<>();
    }

    //getters
    public String getStudentName() { return name; }
    public int getStudentID() { return id; }
    public List<String>  getStudentCourses() { return courses; }
    public List<Double> getStudentGrades() { return grades; }

    //REQUIRES: name != null
    //MODIFIES: this
    //EFFECTS: set the name of the student
    public void setStudentName(String name) {
        this.name = name;
    }

    //REQUIRES: id is positive number
    //MODIFIES: this
    //EFFECTS: set the ID of the student
    public void setStudentID(int id) {
        this.id = id;
    }

    //TODO: Design specification for this method
    //REQUIRES: the grade should be between 0.0 and 4.0, and/or the course should not be null
    //MODIFIES: this
    //EFFECTS: adds a course grade
    public void addCourse(String course, double grade) {
        courses.add(course);
        grades.add(grade);
    }

    //TODO: Design specification for this method
    // This method should return course name and grade in some consistent String format
    //REQUIRES: the course a student has already taken
    //EFFECTS: returns course name and grade in format CourseName: Grade
    public String getCourseAndGrade(String course) {
        String str = course + ": " + grades.get(courses.indexOf(course));
        return str;
    }

    //TODO: Design specification for this method
    //EFFECTS: display student academic record
    public void printTranscript() {
        for (int i=0; i<courses.size(); i++) {
            System.out.print(getCourseAndGrade(courses.get(i)) + ", ");
        }
        System.out.println();
    }

    //TODO: Design specification for this method
    //EFFECTS: access average GPA
    public double getGPA(List<Double> selectedGrades) {
        double average = calculateAverage(selectedGrades);
        return average;
    }

    //TODO: specification
    //EFFECTS: calculate the average GPA of a set of grades
    public double calculateAverage(List<Double> grades){
        //once you complete this method, figure out how to add it as a helper to getGPA()
        double sum = 0.0;

        if (grades.size() != 0) {
            for (double grade : grades) {
                sum = sum + grade;
            }
            return (sum / grades.size());
        }
        else {
            return 0;
        }
    }

    //TODO: specification
    //REQUIRES: a course a student has already taken
    //EFFECTS: get the grade for the corresponding course
    public double getGradeByCourse(String course){
        //this method should return the grade for the given course parameter
        return grades.get(courses.indexOf(course));
    }

    //TODO: specification
    //EFFECTS: calculate the average for the selected courses
    public double getAverageOverSelectedCourses(List<String> selectedCourses){
        //think about which method you can call as a helper!
        ArrayList<Double> grades = new ArrayList<>();

        if (selectedCourses.size() != 0) {
            for (String course : selectedCourses) {
                grades.add(getGradeByCourse(course));
            }
            return calculateAverage(grades);
        }
        else {
            return 0;
        }
    }


}
