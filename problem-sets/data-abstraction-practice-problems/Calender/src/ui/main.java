package ui;

import model.*;

public class main {
    public static void main(String[] args) {
        Calender myCal = new Calender(new Date(15, 8, 2017));
        myCal.setEmail("ahmedgamal1496@gmail.com");

        Date tomorrow = new Date(16, 8, 2017);
        Date nextWeek = new Date(3, 9, 2017);
        Date nextMonth = new Date(20,9,2017);

        Remainder coffee = new Remainder(new Time(6,0), tomorrow, "Buy Coffee");
        coffee.setNote("Hot Chocolate");
        myCal.addEntry(coffee);

        myCal.addEntry(new Event(new Time(15,30), nextWeek, "Doctor appointment"));

        Meeting m = new Meeting(new Time(9, 0), nextMonth, "Scrum");
        m.addAttendee("erikat@ubcxsc.com");
        m.addAttendee("amyz@ubcxsc.com");
        m.addAttendee("jamesy@ubcxsc.com");
        myCal.addEntry(m);

        m.sendInvitation();
        System.out.println();
    }
}
