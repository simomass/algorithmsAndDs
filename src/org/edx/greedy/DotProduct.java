package org.edx.greedy;

import java.util.*;

public class DotProduct {
    private static long maxDotProduct(int[] a, int[] b) {
        //write your code here
        long result = 0;

        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();

        for(int n : a){
            aList.add(n);
        }
        for(int n : b){
            bList.add(n);
        }

        aList.sort(Integer::compareTo);
        bList.sort(Integer::compareTo);

        for (int i = 0; i < a.length; i++) {
            result += (long)aList.get(i) * bList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}