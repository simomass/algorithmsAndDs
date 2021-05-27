package org.edx.adtechniques.introduction;
import java.util.*;

public class FibonacciSumLastDigit {

    private static long getFibonacciPisanoSum(long n) {
        long period = 60;

        n = n % period;

        long prev = 0;
        long curr = 1;

        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        long sum = 1;
        for(int i = 1; i < n; i++)
        {
            long temp = 0;
            temp = curr;
            curr = (prev + curr) % 10;
            prev = temp;
            sum += curr%10;
        }
        return sum % 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciPisanoSum(n);
        System.out.println(s);
        }
}