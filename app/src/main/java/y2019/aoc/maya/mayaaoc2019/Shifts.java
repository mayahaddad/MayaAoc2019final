package y2019.aoc.maya.mayaaoc2019;


public class Shifts {
    private int day;
    private int month;
    private int year;
    private long startingHour;
    private long endingHour;
    private double totalWage;

    public Shifts() {
    }

    public Shifts(int day, int month, int year, long startingHour, long endingHour, double totalWage) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.startingHour = startingHour;
        this.endingHour = endingHour;
        this.totalWage = totalWage;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getStartingHour() {
        return startingHour;
    }

    public void setStartingHour(long startingHour) {
        this.startingHour = startingHour;
    }

    public long getEndingHour() {
        return endingHour;
    }

    public void setEndingHour(long endingHour) {
        this.endingHour = endingHour;
    }

    public double getTotalWage() {
        return totalWage;
    }

    public void setTotalWage(double totalWage) {
        this.totalWage = totalWage;
    }
}
