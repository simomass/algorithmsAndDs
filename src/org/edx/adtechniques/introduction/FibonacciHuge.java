package org.edx.adtechniques.introduction;

import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHuge(long n, long m) {
        long period = findPeriod(m);

        n = n % period;

        long prev = 0;
        long curr = 1;

        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;

        for(int i = 0; i < n - 1; i++)
        {
            long temp = 0;
            temp = curr;
            curr = (prev + curr) % m;
            prev = temp;
        }
        return curr % m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //long n = scanner.nextLong();
        long m = scanner.nextLong();
        for(int i=0; i<=80; i++){
            System.out.println(getFibonacciHuge(i, m));
        }

    }

    private static long findPeriod(long m) {
            long prev = 0;
            long curr = 1;
            long res = 0;

            for(int i = 0; i < m * m; i++)
            {
                long temp = 0;
                temp = curr;
                curr = (prev + curr) % m;
                prev = temp;

                if (prev == 0 && curr == 1)
                    return i + 1;
            }
            return 0;
        }
}


