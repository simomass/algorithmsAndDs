package org.edx.adtechniques.introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(long[] numbers) {
        int n = numbers.length;
        int index = 0;
        for(int i = 1; i<n; i++){
            if(numbers[i]>numbers[index]){
                index = i;
            }
        }
        int index2 = 0;
        if(index==0){
            index2 = 1;
        }
        for(int i = 1; i<n; i++){
            if(i!=index && numbers[i]>numbers[index2]){
                index2=i;
            }
        }
        return numbers[index]*numbers[index2];
    }
/*    static long getMaxPairwiseProductFast(long[] numbers) {
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
    }*/

    public static void main(String[] args) {
/*        long[] numbers = new long[4];
        //for(int i = 1; i < numbers.length; i++){
        //    numbers[i] = i;
        //}
        numbers[0] = 5;
        numbers[1] = 6;
        numbers[2] = 3;
        numbers[3] = 5;*/

        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
       // System.out.println(getMaxPairwiseProductFast(numbers));
    }

/*    static void arraycopy(long[] src, long[] dst, int L) {
        for (int i = 0; i < L; i++) {
            dst[i] = src[i];
        }
    }*/

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

}
