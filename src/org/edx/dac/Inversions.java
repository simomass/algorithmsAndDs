package org.edx.dac;

import java.util.*;

public class Inversions {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(mergeSort(a, b, 0, n-1));
    }

    public static long mergeSort(int[] a, int temp[], int start, int end) {

        long numberOfInversions = 0;

        if (start < end) {
            int mid = (start+end)/ 2;

            numberOfInversions += mergeSort(a, temp, start, mid);

            numberOfInversions += mergeSort(a, temp, mid + 1, end);

            numberOfInversions += merge(a, temp, start, mid + 1, end);

        }
        return numberOfInversions;
    }

    public static long merge(int[] a, int[] temp, int start, int mid, int end) {

        int i = start, j = mid, k = start;

        long inversionCounts = 0;

        while (i <= mid-1 && j <= end ) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            }
            else {
                inversionCounts+=mid-i;
                temp[k++] = a[j++];
            }
        }
        while (i <= mid-1) {
            temp[k++] = a[i++];
        }
        while (j <= end) {
            temp[k++] = a[j++];
        }
        for(int ii = start; ii <= end; ii++){
            a[ii] = temp[ii];
        }

        return inversionCounts;
    }

}