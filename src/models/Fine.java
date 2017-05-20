/*
 This class handles all issues relating to fines asn a result of overdue date
 */
package models;

/**
 *
 * @author philip
 */
public class Fine {

    private long dueDate;
    private long returnDate;
    private long charges = 50;
    private long day;
    private String returnday;

    public Fine(long dueDate, long returnDate) {

        setDueDate(dueDate);
        setReturnDate(returnDate);
    }

    Fine() {

    }

    public void setDueDate(long dueDate) {
        this.dueDate = dueDate;
    }

    public void setReturnDate(long returnDate) {
        this.returnDate = returnDate;
    }

    public long getCharges() {
        return charges;
    }

    public long getDay() {
        return day;
    }

    public String getReturnday() {
        return returnday;
    }

    public void setReturnday(String returnday) {
        this.returnday = returnday;
    }

    public long calculateFine(long dueDate, long returnDate) {
        long fine;
        long payment = 0;
        fine = returnDate - dueDate;
        if (fine > 0) {
            day = fine / (60 * 60 * 1000) / 24;//convert the milliseconds to day 
            payment = day * charges;
        }
        return payment;

    }
}
