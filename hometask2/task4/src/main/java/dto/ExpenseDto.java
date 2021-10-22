package dto;

public class ExpenseDto {
    private int id;
    private String date;
    private int receiver;
    private double value;

    public ExpenseDto(int id, String date, int receiver, double value) {
        this.id = id;
        this.date = date;
        this.receiver = receiver;
        this.value = value;
    }

    public ExpenseDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    @Override
    public String toString() {
        return  "|" + id +
                "|" + date + '|' +
                "|" + receiver +
                "|" + value + "|";
    }
}
