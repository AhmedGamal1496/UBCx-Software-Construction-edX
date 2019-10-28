package model;

public class Entry {
    private Time time;
    private Date date;
    private String label;
    private int intervalOfRepition;

    public Entry(Time time, Date date, String label) {
        this.time = time;
        this.date = date;
        this.label = label;
    }

    //getters
    public Time getTime() { return time; }
    public Date getDate() { return date; }
    public String getLabel() { return label; }
    public int getIntervalOfRepition() { return intervalOfRepition; }

    public boolean isReapeating() {
        return intervalOfRepition != 0;
    }

    public void setIntervalOfRepition(int interval) {
        this.intervalOfRepition = interval;
    }
}
