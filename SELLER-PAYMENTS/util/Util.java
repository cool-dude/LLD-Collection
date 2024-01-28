
/*Seller Payment*/
import model.Payment;

import SystemDesign.VendingMachine.Payment;

import java.util.HashMap;
import java.util.Map;

public class Util {
    static Map<String, Map<String, Payment>> customerMap = new HashMap<>();

    public static Map<String, Map<String, Payment>> getCustomerPaymentMap() {
        return customerMap;
    }
}