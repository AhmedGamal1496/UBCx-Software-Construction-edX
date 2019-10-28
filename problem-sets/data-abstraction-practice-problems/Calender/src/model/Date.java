package model;

public class Date {
    private int day;
    private int month;
    private int year;

    //REQUIRES: 0 < day <= 31, 0 < month <= 12, 0 < year
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    //getters
    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }

    //EFFECTS: return the date in format MM/DD/YYYY
    public String getShortFormat() {
        return month + "/" + day + "/" + year;
    }

    //EFFECTS: returns the date in the format (e.g. January 1, 2017)
    public String getLongFormat() {
        String month = stringMonth(this.getMonth());
        return month + " " + day + "," + " " + year;
    }

    //REQUIRES: month between 1 and 12
    //EFFECTS: return the exact month corresponding to the given number
    private String stringMonth(int month) {
        switch (month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "Mars";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "";
        }
    }
}
