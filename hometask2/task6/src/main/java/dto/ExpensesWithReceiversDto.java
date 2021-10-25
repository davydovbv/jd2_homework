package dto;

public class ExpensesWithReceiversDto {
    private String name;
    private double value;

    public String getName() {
        return name;
    }

    public ExpensesWithReceiversDto(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "|"
                + name +
                "|" + value + "|";
    }
}
