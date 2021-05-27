package org.edx.adtechniques.introduction;

import java.util.*;

public class GCD {
  private static int gcdFast(int a, int b) {

    if(b==0) return a;

    int aPrime = a%b;

    return gcdFast(b, aPrime);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcdFast(a, b));
  }
}
