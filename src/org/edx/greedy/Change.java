package org.edx.greedy;
import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int tenCoins = 0;
        int fiveCoins = 0;
        int oneCoings = 0;

        tenCoins=m/10;
        fiveCoins=(m-tenCoins*10)/5;
        oneCoings=(m-tenCoins*10-fiveCoins*5);

        return tenCoins+fiveCoins+oneCoings;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}


