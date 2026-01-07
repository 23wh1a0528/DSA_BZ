import java.util.*;

public class BitManipulation {

    public static boolean check(long n, int k) {
        return (n & (1L << k)) != 0;
        // or ((n>>k) &1) !=0
    }

    public static long setBit(long n, int k) {
        return n | (1L << k);
    }

    public static long clearBit(long n, int k) {
        return (n & (~(1L << k)));
    }

    public static long flipBit(long n, int k) {
        return n ^ (1L << k);
    }

    public static long powerOf2Calc(int n) {
        return 1L << n;
    }

    public static boolean isPowerOf2(long n) {
        return n > 0 && ( (n & (n - 1)) == 0 );
    }
    
    public static boolean isPowerOf4(long n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }

    public static boolean isPowerOf6(long n) {
        if (n <= 0) return false;
        while (n % 6 == 0) n /= 6;
        return n == 1;
    }

    public static boolean isPowerOf8(long n) {
        if (n <= 0) return false;
        while (n % 8 == 0) n /= 8;
        return n == 1;
    }
    
    public static int findingAkela(int[] arr) {
        int x = 0;
        for (int ele : arr)
            x = x ^ ele;
        return x;
    }

    public static long tripleTrouble(int[] arr) {
        long ans = 0;

        for (int bp = 0; bp <= 63; bp++) {
            int c = 0;
            for (int ele : arr) {
                if (check(ele, bp)) {
                    c++;
                }
            }
            if (c % 3 != 0)
                ans |= (1L << bp);
        }
        return ans;
    }

    public static List<List<Integer>> subsets(int[] arr, int n) {

        List<List<Integer>> outer = new ArrayList<>();
        long m = (1L << n);
        for (int num = 0; num < m; num++) {
            List<Integer> inner = new ArrayList<>();
            for (int bp = 0; bp < n; bp++) {
                if (check(num, bp))
                    inner.add(arr[bp]);
            }
            outer.add(inner);
        }
        return outer;
    }

    public static void missingAndRepeated(int[] arr, int n) {
        int x = 0;
        for (int i = 1; i <= n; i++)
            x = x ^ i;
        for (int ele : arr)
            x ^= ele;

        // instead directly x^= arr[i-1]

        int pos = -1;
        for (int bp = 0; bp <= 63; bp++) {
            if (check(x, bp)) {
                pos = bp;
                break;
            }
        }

        int g1 = 0;
        int g2 = 0;

        for (int ele : arr) {
            if (check(ele, pos)) {
                g1 ^= ele;
            } else {
                g2 ^= ele;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (check(i, pos)) {
                g1 ^= i;
            } else
                g2 ^= i;
        }

        int missing = 0, repeated = 0;
        for (int ele : arr) {
            if (ele == g1) {
                repeated = g1;
                missing = g2;
                break;
            }
            if (ele == g2) {
                repeated = g2;
                missing = g1;
                break;
            }
        }

        System.out.println("Missing Number : " + missing);
        System.out.println("Repeated Number : " + repeated);
    }

public static void main(String[] args) {

        long n = 10;
        int k = 1;

        System.out.println("Check bit : " + check(n, k));
        System.out.println("Set bit : " + setBit(n, k));
        System.out.println("Clear bit : " + clearBit(n, k));
        System.out.println("Flip bit : " + flipBit(n, k));

        System.out.println("2 power n : " + powerOf2Calc(5));

        System.out.println("Power of 2 : " + isPowerOf2(16));
        System.out.println("Power of 4 : " + isPowerOf4(16));
        System.out.println("Power of 6 : " + isPowerOf6(36));
        System.out.println("Power of 8 : " + isPowerOf8(64));

        int[] akelaArr = {2, 3, 5, 3, 2};
        System.out.println("Akela : " + findingAkela(akelaArr));

        int[] tripleArr = {2, 2, 3, 2};
        System.out.println("Triple Trouble : " + tripleTrouble(tripleArr));

        int[] subsetArr = {1, 2, 3};
        List<List<Integer>> res = subsets(subsetArr, subsetArr.length);
        System.out.println("Subsets : " + res);

        int[] missArr = {1, 2, 3, 2, 5};
        missingAndRepeated(missArr, 5);
    }
}
