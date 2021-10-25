package dto;

public class SumOfExpensesOnDateWithBiggestExpenseDto {
    private String paydate;
    private double sumOfExpenses;

    public SumOfExpensesOnDateWithBiggestExpenseDto() {
    }

    public SumOfExpensesOnDateWithBiggestExpenseDto(String paydate, double sumOfExpenses) {
        this.paydate = paydate;
        this.sumOfExpenses = sumOfExpenses;
    }

    public String getPaydate() {
        return paydate;
    }

    public void setPaydate(String paydate) {
        this.paydate = paydate;
    }

    public double getSumOfExpenses() {
        return sumOfExpenses;
    }



    public void setSumOfExpenses(double sumOfExpenses) {
        this.sumOfExpenses = sumOfExpenses;
    }

    @Override
    public String toString() {
        return "|PayDate   |SUM   |" + "\n|" +
                 paydate +  "|" + sumOfExpenses;
    }
}
