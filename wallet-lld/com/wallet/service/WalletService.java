package com.wallet.service;

import java.math.BigDecimal;
import com.wallet.dao.WalletDAO;
import com.wallet.entity.Transaction;
import com.wallet.entity.WalletAccount;

/*digital wallet */
public class WalletService {
    WalletDAO dao;

    public WalletService() {
        dao = new WalletDAO();
    }

    public void createWallet(String f, String l, String phn, BigDecimal amt) {
        WalletAccount ac = new WalletAccount(f, l, phn, amt);
        dao.getAcMap().put(ac.getAccountNum(), ac);
    }

    public boolean isValid(int from, int to, BigDecimal amt) {
        if (from == to) {
            return false;
        }
        if (amt.compareTo(new BigDecimal(0.0001)) < 0) {
            return false;
        }
        if (!dao.getAcMap().containsKey(from)) {
            return false;
        }
        if (!dao.getAcMap().containsKey(to)) {
            return false;
        }
        return true;
    }

    public boolean transfer(int from, int to, BigDecimal amt) {
        if (!isValid(from, to, amt))
            return false;
        Transaction txn = new Transaction(from, to, amt, new Date());
        WalletAccount frm = dao.getAcMap().get(from);
        WalletAccount tto = dao.getAcMap().get(to);
        if (frm.getBalance().compareTo(amt) != 1)
            return false;
        frm.setBalance(frm.getBalance().subtract(amt));
        tto.getBalance(tto.getBalance().add(amt));
        frm.getTransaction().add(txn);
        tto.getTransaction().add(txn);
    }

    public void stmt(int acNum) {
        WalletAccount ac = dao.getAcMap().get(acNum);
        if (ac == null) {
            // Error string
            return;
        }
        System.out.println("Transaction history: ");
        System.out.println(ac.getTransaction());
    }

    public void overview() {
        for (int acNum : dao.getAcMap().keySet()) {
            System.out.println("Balance for ac:" + acNum);
            System.out.println(dao.getAcMap().get(acNum).getBalance());
        }
    }

}
