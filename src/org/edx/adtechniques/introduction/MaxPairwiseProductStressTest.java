package org.edx.adtechniques.introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class MaxPairwiseProductStressTest {

    static long getMaxPairwiseProductFast(long[] numbers) {
        if(numbers.length%2!=0){
            long lastNumber = numbers[numbers.length-1];
            long[] newNumbers = new long[numbers.length-1];
            arraycopy(numbers, newNumbers, numbers.length-1);
            int[] indexes = recursiveIndexFinder(newNumbers);
            if (numbers[indexes[1]]<lastNumber) {
                indexes[1] = numbers.length-1;
            } else if(numbers[indexes[0]]<lastNumber){
                indexes[0] = numbers.length-1;
            }
            return numbers[indexes[0]]* numbers[indexes[1]];
        }
        int[] indexes = recursiveIndexFinder(numbers);
        return numbers[indexes[0]]* numbers[indexes[1]];
    }

    static int[] recursiveIndexFinder(long[] numbers){

        int n = numbers.length;
        if(n==2){
            if(numbers[1]>numbers[0]){
                return new int[]{1, 0};
            } else {
                return new int[]{0, 1};
            }
        }

        //W is to track the largest element
        long[] W = new long[n / 2];
        //M is the swap tracker
        long[] M = new long[n / 2];
        for (int i = 0; i < n / 2; i++) {
            if(numbers[2*i]<numbers[2*i+1]){
                long temp=numbers[2*i];
                numbers[2*i] = numbers[2*i+1];
                numbers[2*i+1] = temp;
                M[i] = 1;
            }
            W[i] = numbers[2*i];
        }
        int[] recursion = recursiveIndexFinder(W);

        double jSwap = M[recursion[0]];
        double kSwap = M[recursion[1]];
        int j = 2* recursion[0];
        int k = 2* recursion[1];
        if(numbers[j+1]>numbers[k]){
            k = j+1;
            kSwap = 0 - jSwap;
        }
        j = (int) (j+jSwap);
        k = (int) (k+kSwap);
        return new int[]{j, k};
    }

    static long getMaxPairwiseProductNaive(long[] numbers){
        long result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (numbers[i] * numbers[j] > result) {
                    result = numbers[i] * numbers[j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        stressTest(5, 9);
    }

    private static void stressTest(int n, int m) {
        int index = 0;
        Random rng = new Random();
        while(true){
           index =  rng.nextInt((n - 2) + 1) + 2 & Integer.MAX_VALUE;
           long[] numbers = new long[index];
           for(int i = 0; i < index; i++){
                numbers[i] = (long)(rng.nextDouble()*(m));
                System.out.println(numbers[i]);
           }
            long result1 = getMaxPairwiseProductFast(numbers);
            long result2 = getMaxPairwiseProductNaive(numbers);
            if(result1==result2){
                System.out.println("OK");
            } else {
                System.out.println("Wrong answer " + result1 + " " + result2);
                return;
            }
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static void arraycopy(long[] src, long[] dst, int L) {
        for (int i = 0; i < L; i++) {
            dst[i] = src[i];
        }
    }
}
