import java.util.*;
public class setops {
    
    // TC: O(N)
    public static void findUnique(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int ele : arr) {
            set.add(ele);
        }
        System.out.println("Unique values : " + set);
    }

    // TC: O(N)
    public static void searchElement(int[] arr, int key) {
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

    // TC: O(N log N)
    public static void sortElements(int[] arr) {
        Set<Integer> set = new TreeSet<>();
        for (int ele : arr) {
            set.add(ele);
        }
        System.out.println("Sorted values : " + set);
    }

    // TC: O(N)
    public static void removeDuplicates(int[] arr) {
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
