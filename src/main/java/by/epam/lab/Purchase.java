package by.epam.lab;

public class Purchase implements Comparable<Purchase> {
    public static final String NAME = "Bread";
    public static final int PRICE = 1000;
    private int number;
    private double percent;
    private WeekDay weekDay;

    public Purchase() {
        this.number = 0;
        this.percent = 0;
        this.weekDay = null;
    }

    public Purchase(int number, double percent, WeekDay weekDay) {
        this.number = number;
        this.percent = percent;
        this.weekDay = weekDay;
    }

    public Purchase(int number, double percent, int day) {
        this.number = number;
        this.percent = percent;
        this.weekDay = WeekDay.values()[day];
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public int getNumber() {
        return number;
    }

    public double getPercent() {
        return percent;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public int getCost(){
        return (int)(PRICE*number*(100-percent)/100);
    }

    @Override
    public String toString() {
        return(number + ";" + percent + ";" + weekDay);
    }

    @Override
    public int compareTo(Purchase purchase){
        return number - purchase.number;
    }
}
