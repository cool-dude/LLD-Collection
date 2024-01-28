/*Ledger company navi */
package model;


public class Payment {
    private double amountPaid;
    private int emiCountLeft;

    public Payment(double amountPaid, int emiCountLeft) {
        this.amountPaid = amountPaid;
        this.emiCountLeft = emiCountLeft;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

}
