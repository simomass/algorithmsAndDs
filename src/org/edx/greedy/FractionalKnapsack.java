package org.edx.greedy;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;

        while(capacity>0){

            int i = bestItem(values, weights);
            if(weights[i]!=0){
                int a = Math.min(weights[i], capacity);
                value += Math.round(a*(double)values[i]/(double)weights[i] * 1000d) / 1000d;
                weights[i] = weights[i] - a;
                capacity -= a;
            } else {
                return value;
            }
        }

        return value;
    }

    private static int bestItem(int[] values, int[] weights){
        int maxValuePerWeight = 0;
        int bestItem =0;
        for(int i = 0; i<values.length; i++){
            if(weights[i]>0){
                if(values[i]/weights[i]>maxValuePerWeight){
                    maxValuePerWeight=values[i]/weights[i];
                    bestItem=i;
                }
            }
        }
        return bestItem;
    }

    // function to get maximum value
        private static double getMaxValue(int capacity, int[] val, int[] wt)
        {
            ItemValue[] iVal = new ItemValue[wt.length];

            for (int i = 0; i < wt.length; i++) {
                iVal[i] = new ItemValue(wt[i], val[i], i);
            }

            // sorting items by value;
            Arrays.sort(iVal, new Comparator<ItemValue>() {
                @Override
                public int compare(ItemValue o1, ItemValue o2)
                {
                    return o2.cost.compareTo(o1.cost);
                }
            });

            double totalValue = 0d;

            for (ItemValue i : iVal) {

                int curWt = (int)i.wt;
                int curVal = (int)i.val;

                if (capacity - curWt >= 0) {
                    // this weight can be picked while
                    capacity = capacity - curWt;
                    totalValue += curVal;
                }
                else {
                    // item cant be picked whole
                    double fraction
                            = ((double)capacity / (double)curWt);
                    totalValue += (curVal * fraction);
                    capacity
                            = (int)(capacity - (curWt * fraction));
                    break;
                }
            }

            return Math.round(totalValue* 1000d) / 1000d;
        }

        // item value class
        static class ItemValue {
            Double cost;
            double wt, val, ind;

            // item value function
            public ItemValue(int wt, int val, int ind)
            {
                this.wt = wt;
                this.val = val;
                this.ind = ind;
                cost = new Double((double)val / (double)wt);
            }
        }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getMaxValue(capacity, values, weights));
    }
}
