import java.util.*;

class BinarySearchOps {

    // 1. Binary Search on Sorted Data

    // Standard binary search in sorted array
    static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
                return mid;
            else if (arr[mid] > key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    // Find floor value (greatest value <= key)
    static int floorValue(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
                return arr[mid];
            else if (arr[mid] > key)
                high = mid - 1;
            else {
                ans = arr[mid];
                low = mid + 1;
            }
        }
        return ans;
    }

    // Find ceil value (smallest value >= key)
    static int ceilValue(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
                return arr[mid];
            else if (arr[mid] > key) {
                ans = arr[mid];
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    // Count number of elements in given range [L, R]
    static int countInRange(int[] arr, int L, int R) {
        int left = ceilValue(arr, L);
        int right = floorValue(arr, R);
        if (left == -1 || right == -1 || left > right)
            return 0;
        return binarySearch(arr, right) - binarySearch(arr, left) + 1;
    }

    // 2. Binary Search Without Array

    // Find integer square root of n using binary search
    static int sqrt(int n) {
        int low = 1, high = n;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((long) mid * mid == n)
                return mid;
            else if ((long) mid * mid < n) {
                ans = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return ans;
    }

    // Find integer cube root of n using binary search
    static int cubeRoot(int n) {
        int low = 1, high = n;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((long) mid * mid * mid == n)
                return mid;
            else if ((long) mid * mid * mid < n) {
                ans = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return ans;
    }

    // 3. Binary Search on Ordered Arrays

    // Count number of zeros (all zeros are on the left)
    static int countNoOfZero(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == 0) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans + 1;
    }

    // Search element in rotated sorted array
    static int searchRotated(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
                return mid;
            if (arr[low] <= arr[mid]) {
                if (key >= arr[low] && key < arr[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if (key > arr[mid] && key <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

    // 4. Binary Search on Answers

    // Helper: check if Koko can eat all piles at given speed within h hours
    static boolean canEat(int[] piles, int speed, int h) {
        int time = 0;
        for (int bananas : piles) {
            time += Math.ceil((double) bananas / speed);
        }
        return time <= h;
    }

    // Find minimum eating speed to finish all piles within h hours
    static int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        int ans = 0;
        for (int x : piles)
            high = Math.max(high, x);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canEat(piles, mid, h)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    // Main method to test all tasks
    public static void main(String[] args) {
        int[] sortedArr = {-5, -3, 0, 10, 20, 25, 30, 36};
        int[] zeroArr = {0, 0, 0, 0, 1, 1, 1};
        int[] rotatedArr = {15, 18, 2, 3, 6, 12};
        int[] bananaPiles = {3, 6, 7, 11};

        // 1. Binary Search on Sorted Data
        System.out.println(binarySearch(sortedArr, 20)); // Index of 20
        System.out.println(floorValue(sortedArr, 22)); // Floor of 22
        System.out.println(ceilValue(sortedArr, 22));  // Ceil of 22
        System.out.println(countInRange(sortedArr, 0, 25)); // Count in [0,25]

        // 2. Binary Search Without Array
        System.out.println(sqrt(40));   // Floor of sqrt(40)
        System.out.println(cubeRoot(30)); // Floor of cube root 30

        // 3. Binary Search on Ordered Arrays
        System.out.println(countNoOfZero(zeroArr));   // Count zeros
        System.out.println(searchRotated(rotatedArr, 3)); // Search in rotated array

        // 4. Binary Search on Answers
        System.out.println(minEatingSpeed(bananaPiles, 8)); // Min speed to finish
    }
}
