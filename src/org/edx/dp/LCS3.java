package org.edx.dp;
import java.util.Scanner;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c, int m, int n, int p, Integer[][][] memoMap) {
        if(m==0 ||n==0 || p == 0)
            return 0;
        if (memoMap[m-1][n-1][p-1]==null)
        {
            if (a[m - 1] == b[n - 1] && b[n-1] == c[p-1]) {
                memoMap[m-1][n-1][p-1]= lcs3(a, b, c, m - 1, n - 1, p-1, memoMap) + 1;
            } else {
                memoMap[m-1][n-1][p-1]= Math.max(
                        lcs3(a, b, c, m, n - 1, p, memoMap),
                        Math.max(lcs3(a, b, c, m - 1, n, p, memoMap),
                                lcs3(a, b, c, m, n, p-1, memoMap)));
            }
        }
        return memoMap[m-1][n-1][p-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }

        Integer[][][] map = new Integer[a.length][b.length][c.length];

        System.out.println(lcs3(a, b, c, a.length, b.length,c.length, map));
    }
}

