package org.edx.divideAndConquer;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.*;
import static java.lang.Math.min;
import static java.lang.Math.sqrt;

public class Closest {

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");

    static double minimalDistance(Point[] points) {
        double ans = Double.POSITIVE_INFINITY;

        if (points.length == 2) {
            return points[0].distance(points[1]);
        } else if (points.length == 3) {
            return min(min(points[0].distance(points[1]), points[1].distance(points[2])),
                    points[0].distance(points[2]));
        } else if (points.length < 2) {
            return Double.POSITIVE_INFINITY;
        }

        Point[] points1 = Arrays.copyOfRange(points, 0, points.length / 2);
        Point[] points2 = Arrays.copyOfRange(points, (points.length / 2), points.length);

        ans = min(minimalDistance(points1), minimalDistance(points2));

        return ans;
    }

    public static void main(String[] args) throws Exception {
/*
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        //int[] x = new int[n];
        //int[] y = new int[n];
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = nextInt();
            int y = nextInt();
            points[i] = new Point(x, y);
        }*/
        Random rand = new Random();

        while (true) {
            int n = rand.nextInt(200);
            Point[] points = new Point[n];
            insertTestData(points, rand);
            Double ans = closestFast(points);
            if (ans == null) throw new Exception("answer is null");
            System.out.println(ans);
        }
        //}
        //writer.close();
    }

    public static Double closestFast(Point[] points) {

        Arrays.sort(points);

        double d = minimalDistance(points);

        if (points.length < 1) return d;

        long centerY = (points[points.length - 1].y + points[0].y) / 2;

        List<Point> newPoints = new ArrayList<>();

        for (Point p : points) {
            Point centerPoint = new Point(p.x, centerY);
            if (centerPoint.distance(p) <= d) newPoints.add(p);
        }

        if (newPoints.size() < 2) {
            System.out.println(d);
            return d;
        }

        Collections.sort(newPoints);

        int i = 0;
        int j = i + 1;

        double ans = Double.POSITIVE_INFINITY;

        while (j < newPoints.size() && i < newPoints.size()) {
            ans = min(newPoints.get(i).distance(newPoints.get(j)), ans);
            if (j - i <= 7) {
                j++;
            } else {
                i++;
            }
        }

        ans = min(ans, d);
        return ans;
    }


    private static void insertTestData(Point[] points, Random rand) {

        //int[] x = new int[n];//{4, -2, -3, -1, 2, -4, 1, -1, 3, -4, -2};
        //int[] y = new int[n];//{4, -2, -4, 3, 3, 0, 1, -1, -1, 2, 4};

        /*for(int i = 0; i<x.length;i++){
            points[i] = new Point(x[i], y[i]);
        }*/


        for (int i = 0; i < points.length; i++) {
            int x = rand.nextInt(100);
            int y = rand.nextInt(100);
            points[i] = new Point(x, y);
        }
    }

    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }

    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {

            return o.y == y ?
                    Long.signum(x - o.x) : //T
                    Long.signum(y - o.y);  //F

        }

        public double distance(Point p) {
            return sqrt((p.y - this.y) * (p.y - this.y) + (p.x - this.x) * (p.x - this.x));
        }
    }

}
