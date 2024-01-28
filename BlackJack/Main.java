/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package designBlackJack;

import java.util.ArrayList;

/** BlackJack */
public class Main {

    public static void main(String[] args) {
        int numHands = 3;

        BlackJackGameAutomator automator = new BlackJackGameAutomator(numHands);
        automator.initializeDeck();
        boolean success = automator.dealInitial();
        if (!success) {
            System.out.println("Error. Out of cards.");
        } else {
            System.out.println("-- Initial --");
            automator.printHandsAndScore();
            // check if blackJacks
            ArrayList<Integer> blackjacks = automator.getBlackJacks();
            if (blackjacks.size() > 0) {
                System.out.print("Blackjack at ");
                for (int i : blackjacks) {
                    System.out.print(i + ", ");
                }
                System.out.println("");
            } else {
                success = automator.playAllHands();
                if (!success) {
                    System.out.println("Error. Out of cards.");
                } else {
                    System.out.println("\n-- Completed Game --");
                    automator.printHandsAndScore();
                    ArrayList<Integer> winners = automator.getWinners();
                    if (winners.size() > 0) {
                        System.out.print("Winners: ");
                        for (int i : winners) {
                            System.out.print(i + ", ");
                        }
                        System.out.println("");
                    } else {
                        System.out.println("Draw. All players have busted.");
                    }
                }
            }
        }
    }
}