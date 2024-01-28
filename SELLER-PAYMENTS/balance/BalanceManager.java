
/*Seller side payments*/
import model.Payment;
import util.Util;

import java.util.List;
import java.util.Map;

public class BalanceManager implements CommandExecution {
    String[] inputSplit;
    BalanceProcessor balanceProcessor;

    public BalanceManager(String[] inputSplit) {
        this.inputSplit = inputSplit;
    }

    public void execute() {
        String bankName = inputSplit[1];
        String customerName = inputSplit[2];
        balanceProcessor = new BalanceProcessor(bankName, customerName);
        processDisplayBalance(bankName, customerName);
    }

    private void processDisplayBalance(String bankName, String custName) {
        Map<String, Map<String,Payment>> custMap = Util.getCustomerPaymentMap().get(customerName);
        Payment custBal = custMap.get(custName);
        List<Payment> paymentList = custBal.getPaymentList();
        paymentList = balanceProcessor.updatePayments(paymentList, emiMonthCount, customerLoan.getEmiAmount(),
                customerLoan.getAmount());
        customerLoan.setPaymentList(paymentList);
        bankLoanMap.put(bankName, customerLoan);
        Util.getUserLoanMapping().get(customerName).put(bankName, customerLoan);
        balanceProcessor.displayBalance(paymentList, emiMonthCount, bankName, customerName);
    }
}