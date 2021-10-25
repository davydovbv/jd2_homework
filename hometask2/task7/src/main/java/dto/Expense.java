package dto;


public class Expense {
    private int id;
    private String paydate;
    private int receiver;
    private double value;

    public Expense() {
    }

    public Expense(int id, String paydate, int receiver, double value) {
        this.id = id;
        this.paydate = paydate;
        this.receiver = receiver;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaydate() {
        return paydate;
    }

    public void setPaydate(String paydate) {
        this.paydate = paydate;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
