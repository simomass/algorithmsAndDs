package org.edx.dac;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PointsAndSegments {

    private static int[] fastCountSegments(List<Pair> pairs, int m) {
        int[] cnt = new int[m];

        pairs.sort((p1, p2)->{
            if(p1.a==p2.a) return Integer.compare(p1.b, p2.b);
            return Integer.compare(p1.a, p2.a);
        });

        int coverage=0;
        for (int i=0; i<pairs.size(); i++) {
            if (pairs.get(i).b == 1) coverage++;
            else if (pairs.get(i).b == 3) coverage--;
            else {
                while (i<pairs.size()&&pairs.get(i).b==2) {
                    cnt[pairs.get(i).index] = coverage;
                    i++;
                }
                i--;
            }
        }

        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static class Pair{
        public int a;
        public int b;
        public int index;

        public Pair(int a, int b) {
            this.a = a;
            this.b=b;
        }
        public Pair(int a, int b, int index) {
            this.a = a;
            this.b=b;
            this.index=index;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        //int[] starts = new int[n];
        //int[] ends = new int[n];
        List<Pair> pairs = new ArrayList<>();
        //int[] points = new int[m];

        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            pairs.add(new Pair(start, 1));
            pairs.add(new Pair(end, 3));
        }

        for (int i = 0; i < m; i++) {
            pairs.add(new Pair(scanner.nextInt(), 2, i));
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(pairs, m);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

