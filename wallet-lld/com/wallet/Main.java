package com.wallet;

import java.math.BigDecimal;
import java.util.Scanner;
/*digital wallet */
import com.wallet.service.WalletService;

public class Main {
    public static void main(String[] args) {
        WalletService ws = new WalletService();
        Scanner sc = new Scanner(System.in);
        here: while (true) {
            System.out.println("\nOPTIONS:");
            System.out.println("1: Create Wallet");
            System.out.println("2: Transfer Amount");
            System.out.println("3: Ac Stmt");
            System.out.println("4: Overview");
            System.out.println("5: Exit");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("CREATE WALLET");
                    System.out.println("Enter fname");
                    String fname = sc.next();
                    System.out.println("Enter Last Name");
                    String lname = sc.next();
                    System.out.println("Enter Phone");
                    String phone = sc.next();
                    System.out.println("Enter bal");
                    BigDecimal bal = sc.nextBigDecimal();
                    ws.createWallet(fname, lname, phone, bal);
                    break;

                case 2:
                    System.out.println("TRASNFER AMT");
                    System.out.println("SENDER ac");
                    int from = sc.nextInt();
                    System.out.println("RECEIVER ac");
                    int to = sc.nextInt();
                    System.out.println("Enter amt");
                    BigDecimal amt = sc.nextBigDecimal();
                    ws.transfer(from, to, amt);
                    break;

                case 3:
                    System.out.println("AC STMT");
                    System.out.println("Enter ac no");
                    ws.stmt(sc.nextInt());
                    break;

                case 4:
                    System.out.println("OVERVIEW");
                    ws.overview();
                    break;

                case 5:
                    System.out.println("Showing menu again");
                    break here;
            }
        }
    }
}