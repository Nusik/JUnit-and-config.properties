package task1;

public class Retail {

    String clientType() {
        String type = "RETAIL";
        return type;
    }

    int minOrder = 1000;

    int TotalOrderSize(int order1, int order2) {
        int total = order1 + order2;
        return total;
    }

    boolean isRegular = true;

    boolean haveDiscount = false;

    public int discountSize() {
        int discount = 20;
        return discount;
    }

    String newClient = null;
}
