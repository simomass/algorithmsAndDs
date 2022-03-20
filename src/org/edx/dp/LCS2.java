package org.edx.dp;
import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b, int m, int n, Map<String, Integer> memoMap) {
        if(m==0 ||n==0)
            return 0;
        String key = m + "_" + n;

        if (!memoMap.containsKey(key))
        {
            if (a[m - 1] == b[n - 1]) {
                memoMap.put(key, lcs2(a, b, m - 1, n - 1, memoMap) + 1);
            } else {
                memoMap.put(key, Math.max(lcs2(a, b, m, n-1, memoMap),
                        lcs2(a, b, m - 1, n, memoMap)));
            }
        }

        return memoMap.get(key);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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

        System.out.println(lcs2(a, b, a.length, b.length, new HashMap<>()));
    }
}

