package task1;

public class Employee {

    public String positionUppercase (String position) {
        return position.toUpperCase();
    }

    String address = null;

    public boolean isNewcomer = true;

    private int daysOfVacationTotal = 30;
    private int daysOfVacationUsed = 25;

    public int DaysOfVacationLeft () {
        return daysOfVacationTotal - daysOfVacationUsed;
    }

    public String group = "Cashier";

    public int numberInGroup() {
        int number = 120;
        return number;
    }
}
