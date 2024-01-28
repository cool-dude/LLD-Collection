package com.wallet.dao;

import java.util.HashMap;
import java.util.*;
import com.wallet.entity.WalletAccount;

/*digital wallet */
public class WalletDAO {
    private Map<Integer, WalletAccount> acMap;

    public WalletDAO() {
        this.acMap = new HashMap<>();
    }

    public Map<Integer, WalletAccount> getAcMap() {
        return this.acMap;
    }

    public void setAccountMap(Map<Integer, WalletAccount> ac) {
        this.acMap = ac;
    }
}
