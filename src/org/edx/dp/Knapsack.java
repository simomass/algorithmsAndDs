package org.edx.dp;
import java.util.Scanner;

public class Knapsack {

    static int optimalWeight(int W, int[] w, int[][] optimalValue) {

        int[] fixedW = new int[w.length+1];
        for(int i=1; i<= w.length;i++)
            fixedW[i]=w[i-1];

        for (int i = 1; i <= w.length; i++) {
            int[] tmpW = fixedW;
            for (int j = 1; j <= W; j++) {
                optimalValue[i][j] = optimalValue[i-1][j];
                if (tmpW[i] <= j) {
                    int tmpOptVal = tmpW[i] + optimalValue[i - 1][j - tmpW[i]];
                    if (optimalValue[i][j] < tmpOptVal)
                        optimalValue[i][j] = tmpOptVal;
                }
            }
        }
        return optimalValue[w.length][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        int[][] memo = new int[n+1][W+1];
        System.out.println(optimalWeight(W, w, memo));
    }
}

