package y2019.aoc.maya.mayaaoc2019;

import java.util.Date;

public class Shifts {
    private Date date;
    private long startingHour;
    private long endingHour;
    private double totalWage;

    public Shifts(Date date, String s, String s1, String s2) {
    }

    public Shifts (Date date, long startingHour, long endingHour, double totalWage){
        this.date=date;
        this.startingHour=startingHour;
        this.endingHour=endingHour;
        this.totalWage=totalWage;
    }

    public long getStartingHour() {
        return startingHour;
    }

    public void setStartingHour(long startingHour) {
        this.startingHour = startingHour;
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalWage() {
        return totalWage;
    }

    public void setTotalWage(double totalWage) {
        this.totalWage = totalWage;
    }

    public long getEndingHour() {

        return endingHour;
    }

    public void setEndingHour(long endingHour) {
        this.endingHour = endingHour;
    }
}
