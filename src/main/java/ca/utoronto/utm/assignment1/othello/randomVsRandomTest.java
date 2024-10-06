package ca.utoronto.utm.assignment1.othello;

import java.util.Random;

public class randomVsRandomTest {

    public static void main(String[] args) {
        System.out.println("This first version switches who goes first every other trial.");
        System.out.println("-------------------------------------------------------------");
        int numGames = 1000, numTrials = 10, p1ThresholdCount = 0, p2ThresholdCount = 0;
        double threshold = 0.05;
        for (int i = 0; i < numTrials; i++) {
            int p1wins = 0, p2wins = 0;
            for (int j = 0; j < numGames; j++) {
                OthelloControllerRandomVSRandom oc = new OthelloControllerRandomVSRandom();
                oc.play();
                if (oc.othello.getWinner() == OthelloBoard.P1 && i%2 == 1) {
                    p2wins++;
                }
                else if (oc.othello.getWinner() == OthelloBoard.P1) {
                    p1wins++;
                }
                else if (oc.othello.getWinner() == OthelloBoard.P2 && i%2 == 1) {
                    p1wins++;
                }
                else if (oc.othello.getWinner() == OthelloBoard.P2) {
                    p2wins++;
                }
            }
            if (i%2 == 1) {
                System.out.println("Trial " + (i + 1) + ":" + " Players Turn Swapped");
            }
            else {
                System.out.println("Trial " + (i + 1) + ":" + " No Turns Swapped");
            }
            float p1WinRate = (float) p1wins / numGames;
            float p2WinRate = (float) p2wins / numGames;
            System.out.println("Probability P1 wins=" + p1WinRate);
            System.out.println("Probability P2 wins=" + p2WinRate);
            if (Math.abs(p1WinRate - p2WinRate) > threshold) {
                System.out.println("There is a significant difference in win rates.");
                if (p1WinRate > p2WinRate) {
                    System.out.println("Player 1 has an advantage.");
                    p1ThresholdCount ++;
                }
                else if (p2WinRate > p1WinRate) {
                    System.out.println("Player 2 has an advantage.");
                    p2ThresholdCount ++;
                }
            }
        }
        int trial1Total = p1ThresholdCount + p2ThresholdCount;
        System.out.println("Out of " + numTrials + " trials:");
        System.out.println("Player 1 had an advantage in " + p1ThresholdCount + " trials.");
        System.out.println("Player 2 had an advantage in " + p2ThresholdCount + " trials.");
        System.out.println("-------------------------------------------------------------");

        System.out.println("This second version is only considering p1 going first each time.");
        System.out.println("-------------------------------------------------------------");
        p1ThresholdCount = 0;
        p2ThresholdCount = 0;
        for (int i = 0; i < numTrials; i++) {
            int p1wins = 0, p2wins = 0;
            for (int j = 0; j < numGames; j++) {
                OthelloControllerRandomVSRandom oc = new OthelloControllerRandomVSRandom();
                oc.play();
                if (oc.othello.getWinner() == OthelloBoard.P1) {
                    p1wins++;
                }
                else if (oc.othello.getWinner() == OthelloBoard.P2) {
                    p2wins++;
                }
            }
            System.out.println("Trial " + (i+1) + ":");
            float p1WinRate = (float) p1wins / numGames;
            float p2WinRate = (float) p2wins / numGames;
            System.out.println("Probability P1 wins=" + p1WinRate);
            System.out.println("Probability P2 wins=" + p2WinRate);
            if (Math.abs(p1WinRate - p2WinRate) > threshold) {
                System.out.println("There is a significant difference in win rates.");
                if (p1WinRate > p2WinRate) {
                    System.out.println("Player 1 has an advantage.");
                    p1ThresholdCount ++;
                }
                else if (p2WinRate > p1WinRate) {
                    System.out.println("Player 2 has an advantage.");
                    p2ThresholdCount ++;
                }
            }
        }
        int trial2Total = p2ThresholdCount + p1ThresholdCount;
        System.out.println("Out of " + numTrials + " trials:");
        System.out.println("Player 1 had an advantage in " + p1ThresholdCount + " trials.");
        System.out.println("Player 2 had an advantage in " + p2ThresholdCount + " trials.");
        System.out.println("-------------------------------------------------------------");
        System.out.println("For the first version of the trials, there were " + (trial1Total) + " trials above the threshold.");
        System.out.println("For the first version of the trials, there were " + (trial2Total) + " trials above the threshold.");
    }
}
