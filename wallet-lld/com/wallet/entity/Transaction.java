package com.wallet.entity;

/*digital wallet */
import java.math.BigDecimal;
import java.sql.Date;

public class Transaction {
    String from;
    String to;
    BigDecimal amt;
    Date date;

    public Transaction(String f, String t, BigDecimal a, Date d) {
        from = f;
        to = t;
        amt = a;
        date = d;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public BigDecimal getAmount() {
        return amt;
    }

    public Date getDate() {
        return date;
    }
}
