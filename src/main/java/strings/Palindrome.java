package strings;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("harish"));
        System.out.println(isPalindrome("lll"));

    }

    private static boolean isPalindrome(final String str) {
        if (str == null) return false;
        if (str.isEmpty()) return true;
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
}
