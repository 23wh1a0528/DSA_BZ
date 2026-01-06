import java.util.*;

class mapops {

    static int countDistinct(int[] arr) {
        // TC: O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, 1);
        }
        return map.size();
    }

    static void insertAndDisplay(HashMap<Integer, Integer> map, int key, int value) {
        // TC: O(1)
        map.put(key, value);
        System.out.println(map);
    }

    static boolean searchKey(HashMap<Integer, Integer> map, int key) {
        // TC: O(1)
        return map.containsKey(key);
    }

    static void findDuplicates(int[] arr) {
        // TC: O(n)
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) > 1) {
                System.out.println(key);
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 4, 4, 5};
        System.out.println(countDistinct(arr));
        HashMap<Integer, Integer> map = new HashMap<>();
        insertAndDisplay(map, 1, 10);
        insertAndDisplay(map, 2, 20);
        System.out.println(searchKey(map, 2));
        findDuplicates(arr);
    }
}
