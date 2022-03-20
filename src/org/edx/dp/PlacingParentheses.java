package org.edx.dp;
import java.util.Scanner;

import static java.lang.Long.max;
import static java.lang.Long.min;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
        String[] split = exp.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");
        long[] number = new long[(split.length / 2) + 1];
        char[] op = new char[split.length / 2];
        for (int i = 0; i < split.length; i++) {
            try {
                number[i / 2] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                op[i / 2] = split[i].charAt(0);
            }
        }
        int n = number.length;

        long[][] m = new long[n][n];
        long[][] M = new long[n][n];

        for (int i = 0; i < n; i++) {
            m[i][i] = number[i];
            M[i][i] = number[i];
        }

        for (int s = 1; s <= n; s++) {
            for (int i = 0; i < n - s; i++) {
                int j = i + s;
                minMax(op, i, j, m, M);
            }
        }
        return M[0][n - 1];
    }

    private static void minMax(char[] op, int i, int j, long[][] m, long[][] M) {
        M[i][j] = Long.MIN_VALUE;
        m[i][j] = Long.MAX_VALUE;
        for (int k = i; k < j; k++) {
            long a = eval(M[i][k], M[k + 1][j], op[k]);
            long b = eval(M[i][k], m[k + 1][j], op[k]);
            long c = eval(m[i][k], M[k + 1][j], op[k]);
            long d = eval(m[i][k], m[k + 1][j], op[k]);
            m[i][j] = min(m[i][j], min(min(min(a, b), c), d));
            M[i][j] = max(M[i][j], max(max(max(a, b), c), d));
        }
    }


    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

