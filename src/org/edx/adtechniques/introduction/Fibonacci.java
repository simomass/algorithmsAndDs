package org.edx.adtechniques.introduction;

import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {

    if(n<2){
      return n;
    }

    long[] vec = new long[n+1];

    vec[0] = 0;
    vec[1] = 1;

    for(int i = 2; i<=n; i++){
      vec[i] = vec[i-1] + vec[i-2];
    }
    return vec[n];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
