public class recursionops {
    
    public static int factorial(int n) {
        if (n == 0) 
            return 1;
        return n * factorial(n - 1);
    }

    public static int fibonacci(int n) {
        if (n <= 1) 
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int power(int a, int b) {
        if (b == 0) return 1;
        return a * power(a, b - 1);
    }

    public static int sumOfDigits(int n) {
        if (n == 0) return 0;
        return (n % 10) + sumOfDigits(n / 10);
    }

    public static String reverseString(String s) {
        if (s.length() == 0) return s;
        return reverseString(s.substring(1)) + s.charAt(0);
    }

    public static int binarySearch(int[] arr, int low, int high, int key) {
        if (low > high) 
            return -1;
        int mid = (low + high) / 2;
        if (arr[mid] == key) 
            return mid;
        if (key < arr[mid]) 
            return binarySearch(arr, low, mid - 1, key);
        return binarySearch(arr, mid + 1, high, key);
    }

    public static void reverseArray(int[] arr) {
        reverseHelper(arr, 0, arr.length - 1);
    }
    public static void reverseHelper(int[] arr, int i, int j) {
        if (i >= j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        reverseHelper(arr, i + 1, j - 1);
    }

    public static void print1ToN(int n) {
        if (n == 0) return;
        print1ToN(n - 1);
        System.out.print(n + " ");
    }

    public static void printNTo1(int n) {
        if (n == 0) return;
        System.out.print(n + " ");
        printNTo1(n - 1);
    }

    // Binary Exponentiation
    public static long powMod(long a, long b, long m) {
        if (b == 0) 
            return 1;
        if (b == 1) 
            return a % m;
            
        long half = powMod(a, b / 2, m);
        long sq = ((half % m) * (half % m)) % m;
        
        if ((b & 1) == 0) 
            return sq;
        return (sq * (a % m)) % m;
    }

    // Matrix Exponentiation
    public static long[][] matExp(long[][] a, long b, long m) {
        if (b == 0) 
            return identity(a.length);
        if (b == 1) 
            return a;
            
        long[][] half = matExp(a, b / 2, m);
        long[][] sq = multiply(half, half, m);
        
        if ((b & 1) == 0) 
            return sq;
        return multiply(sq, a, m);
    }

    public static long[][] multiply(long[][] a, long[][] b, long m) {
        int n = a.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % m;
        return res;
    }

    public static long[][] identity(int n) {
        long[][] id = new long[n][n];
        for (int i = 0; i < n; i++) id[i][i] = 1;
        return id;
    }

    public static void main(String[] args) {

        System.out.println("Factorial: " + factorial(5));
        System.out.println("Fibonacci: " + fibonacci(6));
        System.out.println("Power: " + power(2, 5));
        System.out.println("Sum of Digits: " + sumOfDigits(1234));
        System.out.println("Reverse String: " + reverseString("recursion"));

        int[] arr = {1, 3, 5, 7, 9};
        System.out.println("Binary Search: " + binarySearch(arr, 0, arr.length - 1, 7));

        int[] a = {1, 2, 3, 4};
        reverseArray(a);
        System.out.println("Reversed Array: " + java.util.Arrays.toString(a));

        System.out.print("1 to N: ");
        print1ToN(5);
        System.out.println();

        System.out.print("N to 1: ");
        printNTo1(5);
        System.out.println();

        System.out.println("Binary Exponentiation: " + powMod(2, 10, 1000000007));
    }
}
