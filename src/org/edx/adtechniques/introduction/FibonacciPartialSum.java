package org.edx.adtechniques.introduction;

import java.util.*;

public class FibonacciPartialSum {

    private static long getFibonacciPartialSum(long from, long to) {

        from = from % 60;
        to = to % 60;
        long next = 1;
        long curr = 0;
        long sum = 0;

        for (int i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += curr % 10;
            }
            long temp = next;
            next = (next + curr) % 10;
            curr = temp;
        }
        return sum % 10;

    }


    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSum(from, to));
    }
}