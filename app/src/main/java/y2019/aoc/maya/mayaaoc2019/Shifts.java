package y2019.aoc.maya.mayaaoc2019;

import java.util.Date;

public class Shifts {
    private Date date;
    private String startingHour;
    private String endingHour;
    private String totalWage;

    public Shifts() {
    }

    public Shifts (Date date, String startingHour, String endingHour, String totalWage){
        this.date=date;
        this.startingHour=startingHour;
        this.endingHour=endingHour;
        this.totalWage=totalWage;
    }

    public String getStartingHour() {
        return startingHour;
    }

    public void setStartingHour(String startingHour) {
        this.startingHour = startingHour;
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTotalWage() {
        return totalWage;
    }

    public void setTotalWage(String totalWage) {
        this.totalWage = totalWage;
    }

    public String getEndingHour() {

        return endingHour;
    }

    public void setEndingHour(String endingHour) {
        this.endingHour = endingHour;
    }
}
