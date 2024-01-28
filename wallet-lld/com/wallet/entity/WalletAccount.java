package com.wallet.entity;

/*digital wallet */
import java.math.BigDecimal;
import java.util.TreeSet;
import java.util.Set;

import com.wallet.service.NumGenerator;

public class WalletAccount {
    private int accountNum;
    private User user;
    private BigDecimal balance;
    private Set<Transaction> transactions;

    public WalletAccount(String f, String l, String phn, BigDecimal b) {
        accountNum = NumGenerator.getNum();
        user = new User(f, l, phn);
        balance = b;
        transactions = new TreeSet<>((x, y) -> x.getDate().comparetTo(y.getDate()));
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int ac) {
        accountNum = ac;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User u) {
        user = u;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal bal) {
        balance = bal;
    }

    public Set<Transaction> getTransaction() {
        return transactions;
    }

    public void setTrans(TreeSet<Transaction> t) {
        transactions = t;
    }
}