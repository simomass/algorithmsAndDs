package org.edx.adtechniques.introduction;
import java.util.*;

public class LCM {

  private static long lcm(long a, long b){
    if(a%b==0){
      return a;
    } else if (b%a==0){
      return b;
    }

    long lcm = a*b/gcdFast(a,b);
    return lcm;
  }

  private static long gcdFast(long a, long b) {

    if(b==0) return a;

    long aPrime = a%b;

    return gcdFast(b, aPrime);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm(a, b));
  }
}
