package com.wallet.entity;

import java.util.UUID;

/*digital wallet */
public class User {
    private String id;
    private String fName;
    private String lName;
    private String phoneNumber;

    public User(String fNString, String lNString, String phnNum) {
        id = UUID.randomUUID().toString();
        fName = fNString;
        lName = lNString;
        phoneNumber = phnNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id_) {
        id = id_;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String f) {
        fName = f;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String l) {
        lName = l;
    }

    public String gePhone() {
        return phoneNumber;
    }

    public void setPhone(String p) {
        phoneNumber = p;
    }
}