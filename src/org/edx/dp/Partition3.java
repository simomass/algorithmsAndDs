package org.edx.dp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Partition3 {

    private static int partition3(int[] A) {
        int sum = 0;

        if (A.length < 3)
            return 0;

        for (int num : A)
            sum += num;

        if (sum % 3 != 0)
            return 0;

        int goal = sum / 3;

        int[][] optimalValue = new int[A.length + 1][goal + 1];

        int[] fixedW = new int[A.length + 1];
        for (int i = 1; i <= A.length; i++)
            fixedW[i] = A[i - 1];

        for (int i = 1; i <= A.length; i++) {
            int[] tmpW = fixedW;
            for (int j = 1; j <= goal; j++) {
                optimalValue[i][j] = optimalValue[i - 1][j];
                if (tmpW[i] <= j) {
                    int tmpOptVal = tmpW[i] + optimalValue[i - 1][j - tmpW[i]];
                    if (optimalValue[i][j] < tmpOptVal)
                        optimalValue[i][j] = tmpOptVal;
                }
            }
        }

        return optimalValue[A.length][goal] == goal ? 1 : 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}


