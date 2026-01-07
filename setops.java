import java.util.*;
public class setops {
    
    public static void findUnique(int[] arr) {
        // TC: O(N)
        Set<Integer> set = new HashSet<>();
        for (int ele : arr) {
            set.add(ele);
        }
        System.out.println("Unique values : " + set);
    }

    public static void searchElement(int[] arr, int key) {
        // TC: O(N)
        Set<Integer> set = new HashSet<>();
        for (int ele : arr) {
            set.add(ele);
        }
        if (set.contains(key)) {
            System.out.println("Element Found");
        } else {
            System.out.println("Element Not Found");
        }
    }

    public static void sortElements(int[] arr) {
        // TC: O(N log N)
        Set<Integer> set = new TreeSet<>();
        for (int ele : arr) {
            set.add(ele);
        }
        System.out.println("Sorted values : " + set);
    }

    public static void removeDuplicates(int[] arr) {
        // TC: O(N)
        Set<Integer> set = new HashSet<>();
        for (int ele : arr) {
            set.add(ele);
        }
        System.out.println("After removing duplicates : " + set);
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 2, 5, 1};
        findUnique(arr);
        searchElement(arr, 8);
        sortElements(arr);
        removeDuplicates(arr);
    }
}
