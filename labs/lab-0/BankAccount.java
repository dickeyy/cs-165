public class BankAccount {

    private String name;
    private double checking;
    private double savings;

    public BankAccount(String newName, double amt1, double amt2) {
        name = newName;
        checking = amt1;
        savings = amt2;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public void setChecking(double amt) {
        checking = amt;
    }

    public double getChecking() {
        return checking;
    }

    public void setSavings(double amt) {
        savings = amt;
    }

    public double getSavings() {
        return savings;
    }

    public void depositChecking(double amt) {
        if (amt > 0) {
            checking += amt;
        }
    }

    public void depositSavings(double amt) {
        if (amt > 0) {
            savings += amt;
        }
    }

    public void withdrawChecking(double amt) {
        if (amt > 0) {
            checking -= amt;
        }
    }

    public void withdrawSavings(double amt) {
        if (amt > 0) {
            savings -= amt;
        }
    }

    public void transferToSavings(double amt) {
        if (amt > 0) {
            checking -= amt;
            savings += amt;
        }
    }

}
