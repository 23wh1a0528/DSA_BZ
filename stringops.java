import java.util.*;

public class stringops {

    public static void countCharacters(String s) {
        int spc = 0;
        int sum = 0;
        int space = 0;
        int up = 0;
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (Character.isDigit(ch)) {   
                sum += (ch - '0');
            }
            else if (Character.isWhitespace(ch)) {
                space++;
            }
            else if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    up++;
                } else {
                    spc++;
                }
            }
        }

        System.out.println("Digit Sum : " + sum);
        System.out.println("Spaces : " + space);
        System.out.println("Uppercase letters : " + up);
        System.out.println("Lowercase letters : " + spc);
    }

    public static int countSub(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if (sl < tl)
            return 0;
        int c = 0;
        for (int i = 0; i <= sl - tl; i++) {
            String sub = s.substring(i, i + tl);
            if (sub.equals(t)) {
                c++;
            }
         // case insensitive: if(sub.equalsIgnoreCase(t))
        }
        return c;
    }

    public static int splitAndSum(String s) {
        String[] sa = s.split(" ");
        int sum = 0;
        for (String str : sa) {
            sum += Integer.parseInt(str);
        }
        return sum;
    }


    public static long longestPrimeSubstring(String s) {
    // constraints: length <= 18
        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                long num = Long.parseLong(sub);
                if (isPrime(num)) {
                    ans = Math.max(ans, num);
                }
            }
        }
        return ans;
    }
    public static boolean isPrime(long n) {
        if (n <= 1)
            return false;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void stringBuilderDemo() {

        StringBuilder sb = new StringBuilder("Hello");
    
        sb.append(" World");
        System.out.println(sb);
    
        sb.insert(5, " Java");
        System.out.println(sb);
    
        sb.delete(5, 10);
        System.out.println(sb);
    
        sb.deleteCharAt(0);
        System.out.println(sb);
    
        String sub = sb.substring(0, 5);
        System.out.println(sub);
    
        sb.reverse();
        System.out.println(sb);
    
        sb.reverse(); 
    
        sb.setCharAt(0, 'h');
        System.out.println(sb);
    
        String finalString = sb.toString();
        System.out.println(finalString);
    
        System.out.println("Length : " + sb.length());
}

    public static String reverseString(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {

        String s = "Hello World 123";

        countCharacters(s);

        System.out.println("Substring count : " + countSub("abababa", "aba"));

        System.out.println("Split Sum : " + splitAndSum("10 20 30 40"));

        System.out.println("Longest Prime Substring : " +
                longestPrimeSubstring("11373"));

        stringBuilderDemo();

        System.out.println("Reversed String : " +
                reverseString("Strings"));
    }
}
