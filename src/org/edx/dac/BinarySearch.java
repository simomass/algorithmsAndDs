package org.edx.dac;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BinarySearch {

    static int binarySearch(List<Integer> numbers, int x) {
        int left = 0, right = numbers.size()-1;

        while (left <= right){
            int mid = left+ (right-left)/2;
            if (Integer.valueOf(x).equals(numbers.get(mid))){
                return mid;
            } else if (Integer.valueOf(x).compareTo(numbers.get(mid)) == -1){
                right = mid-1;
            } else {
                left = mid +1;
            }
        }

        return -1;
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        List<Integer> numbers = new ArrayList<>();

        for(int k : a){
            numbers.add(k);
        }

        numbers = numbers.stream().distinct().sorted(Integer::compareTo).collect(Collectors.toList());

        for (int i = 0; i < m; i++) {
            System.out.println(binarySearch(numbers, b[i])+" ");
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
}
