package org.edx.greedy;
import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int prize = 0;
        int rest = 0;
        int totalPrizes=0;
        for(int i =0; i < n ; i++){
            prize = prize+1;
            summands.add(prize);
            totalPrizes+=prize;
            rest = n-totalPrizes;
            if(rest<=prize){
                summands.set(i, summands.get(i)+rest);
                return summands;
            }
        }

        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}