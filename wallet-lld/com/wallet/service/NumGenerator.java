package com.wallet.service;

/*digital wallet */
public class NumGenerator {
    private static int num = 1;

    public static int getNum() {
        return num++;
    }
}
