package model;

import exceptions.CourseFullException;
import exceptions.GPATooLowException;
import exceptions.MissingPrereqException;
import exceptions.NoCoursesTakenException;

import java.util.ArrayList;
import java.util.List;

public class Transcript {

    private String name;
    private int year;
    private int id;
    private double gpa;
    private List<Course> currentCourses;
    private List<Course> pastCourses;

    public Transcript(String studentName, int academicYear, int studentID) {
        // TODO: complete the implementation of this method
        name = studentName;
        year = academicYear;
        id = studentID;
        gpa = 0;
        currentCourses = new ArrayList<>();
        pastCourses = new ArrayList<>();
    }

    // getters
    public String getName() {
        // TODO: complete the implementation of this method
        return name;
    }

    public int getAcademicYear() {
        // TODO: complete the implementation of this method
        return year;
    }

    public int getId() {
        // TODO: complete the implementation of this method
        return id;
    }

    public List<Course> getCurrentCourses() {
        // TODO: complete the implementation of this method
        return currentCourses;
    }

    public List<Course> getPastCourses() {
        // TODO: complete the implementation of this method
        // HINT: you may need to consider what kind of information a completed
        // course on a transcript needs to have that the Course class
        // doesn't already contains
        return pastCourses;
    }

    // EFFECTS: computes cGPA
    //          if the list of past courses is empty, throws NoCoursesTakenException
    public double computeGPA() throws NoCoursesTakenException {
        //          HINTS:
        //          use the following formula to convert into a GPA
        //          GPA (4.0 scale) = (total percentage/20) - 1
        //          **Do you need a helper method?**
        
        // TODO: complete the implementation of this method
        double totalPerc = 0;

        if (pastCourses.size() == 0) {
            throw new NoCoursesTakenException("There are no courses taken, yet");
        }
        else {
            for (Course c : pastCourses) {
                totalPerc += c.getGrade();
            }
            totalPerc = totalPerc / pastCourses.size();
            return ((totalPerc/20) - 1);
        }
    }

    // EFFECTS: promotes the student represented by the transcript
    //          to the next academic year if GPA is over 2.6 on a 4.0 scale, and return true
    //          else return false with no change to the year field
    //          if GPA is not over 2.6 on a 4.0 scale, throws GPATooLowException
    //          if no courses have been taken, throws NoCoursesTakenException
    public boolean promoteStudent() throws GPATooLowException, NoCoursesTakenException {
        
        // TODO: complete the implementation of this method
        if (pastCourses.size() == 0) {
            throw new NoCoursesTakenException("There are no courses taken, yet");
        }
        else if (this.computeGPA() < 2.6) {
            throw new GPATooLowException("GPA is too low for this student");
        }
        else {
            this.year++;
            return true;
        }
    }


    // MODIFIES: this
    // EFFECTS: adds the given course to the list of past courses and returns true,
    //          unless pastCourses contains given course, then does not add and returns false
    public boolean addToPastCourses(Course c) {
        //TODO: implement this method
        if (!pastCourses.contains(c)) {
            pastCourses.add(c);
            return true;
        }

        return false;
    }

    // MODIFIES: this
    // EFFECTS: adds a course (c) into the record
    //          if the transcript is missing prerequisites, throws a MissingPrereqException
    //          if the course has no space for more students to register, throws a CourseFullException
    public boolean addCourse(Course course) throws MissingPrereqException, CourseFullException {
        // TODO: implement this method.
        // You have to realize that there are a number of cases that your code needs to consider. What if the course
        // you wish to add has no prerequisites? What if the course you want to add is already full?
        // Careful consideration of these cases will lead to code that is correct
        if (!checkPrereq(course)) {
            throw new MissingPrereqException("There are missing prereq courses");
        }
        else if (course.isCourseFull()) {
            throw new CourseFullException("This course is already full");
        }
        else {
            currentCourses.add(course);
            return true;
        }
    }

    private boolean checkPrereq(Course c) {
        int counter = 0;

        for (Course prereq : c.getPrereq()) {
            if (this.pastCourses.contains(prereq)) {
                counter++;
            }
        }

        return (counter == c.getPrereq().size());
    }


}
