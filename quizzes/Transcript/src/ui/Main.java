package ui;

import model.Transcript;

public class Main {
    public static void main(String[] args){
        Transcript t1 = new Transcript("Jane Doe", 7830);
        Transcript t2 = new Transcript("Ada Lovelace", 8853);
        //TODO: create another Transcript object
        Transcript t3 = new Transcript("Jimbo", 9987);

        t1.addCourse("CPSC-210", 3.5);
        t1.addCourse("ENGL-201", 4.0);
        t1.addCourse("CPSC-110", 3.1);

        //TODO: add grades to the other Transcript objects
        t2.addCourse("CPSC-210", 1.5);
        t2.addCourse("ENGL-201", 2.7);
        t2.addCourse("CPSC-110", 1.1);

        t3.addCourse("CPSC-210", 3.9);
        t3.addCourse("ENGL-201", 4.0);
        t3.addCourse("CPSC-110", 4.0);

        System.out.print(t2.getStudentName() + ": ");
        t2.printTranscript();

        System.out.println("GPA: " + t2.getGPA(t2.getStudentGrades()));

        // extra problems
        System.out.println(t3.getStudentName() + ": " + t3.getStudentID());
        for (String course : t3.getStudentCourses()) {
            System.out.println(course + ": " + t3.getGradeByCourse(course));
        }
        System.out.println("AVERAGE: " + t3.getAverageOverSelectedCourses(t3.getStudentCourses()));
    }
}
