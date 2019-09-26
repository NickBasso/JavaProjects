package sample;

public class Money extends Definitions{
    // fields
    private double moneyAvaible = undefinedDouble;
    private double totalMonthlyIncome = undefinedDouble;
    private double totalMonthlyExpenses = undefinedDouble;

    // constructor
    public Money(double thisMoneyAvaible, double thistotalMonthlyIncome, double thistotalMonthlyExpenses){
        moneyAvaible = thisMoneyAvaible;
        totalMonthlyIncome = thistotalMonthlyIncome;
        totalMonthlyExpenses = thistotalMonthlyExpenses;
    }

    // setters (set methods)
    protected void setMoneyAvaible(double thisMoneyAvaible){
        moneyAvaible = thisMoneyAvaible;
    }

    protected void settotalMonthlyIncome(double thisTotalMonthlyIncome){
        totalMonthlyIncome = thisTotalMonthlyIncome;
    }

    protected void settotalMonthlyExpenses(double thisTotalMonthlyExpenses){
        totalMonthlyExpenses = thisTotalMonthlyExpenses;
    }

    // print methods
    protected void printMoneyAvaible(){
        System.out.println(moneyAvaible);
    }
    
    protected void printTotalMonthlyIncome(){
        System.out.println(totalMonthlyIncome);
    }
    
    protected void printTotalMonthlyExpenses(){
        System.out.println(totalMonthlyExpenses);
    }
}
