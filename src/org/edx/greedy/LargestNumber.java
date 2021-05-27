package org.edx.greedy;

import java.util.*;

public class LargestNumber {
    private static String largestNumber(List<String> a) {
        //write your code here
        StringBuilder result = new StringBuilder();

        a.sort((s1, s2) -> {return new String(s2+s1).compareTo(s1+s2);});

        for (String s : a) {
            result.append(s);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //String[] a = new String[n];
        List<String> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.next());
        }
        System.out.println(largestNumber(a));
    }

}

//2, 21, 39, 92