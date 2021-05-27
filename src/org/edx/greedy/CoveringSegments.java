package org.edx.greedy;
import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        List<Segment> sList = new ArrayList<>();

        for(Segment s : segments){
            sList.add(s);
        }

        sList.sort((s1, s2)->Integer.valueOf(s1.end).compareTo(s2.end) );

        List<Integer> intSegments = new ArrayList<>();
        int i = 0;
        while(i<sList.size()){
            int j = i+1;
            while(j < sList.size() && sList.get(i).isIntersecting(sList.get(j))) {
                j++;
                }
            intSegments.add(sList.get(i).end);
            i=j;
        }
        int[] points = new int[intSegments.size()];

        for(int k = 0; k<points.length;k++){
            points[k] = intSegments.get(k);
        }


        return points;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean isIntersecting(Segment segmentToCompare){
            return this.end>=segmentToCompare.start && this.start<=segmentToCompare.end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }

        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
