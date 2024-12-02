package strings;

import arrays.SortedArray2Sum;

public class IsSubSequence_392 {
    /*

    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

    A subsequence of a string is a sequence of characters that can be obtained by deleting some (or none) of the characters from the original string,
    while maintaining the relative order of the remaining characters. For example, "ace" is a subsequence of "abcde" while "aec" is not.
     */

    private static boolean isSubsequence(final String s, final String t) {
        int i = 0, j = 0;
        int m = s.length(), n = t.length();
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        if (i < m) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "acfe";
        String t = "abcde";
        System.out.println(isSubsequence(s, t));
    }


}
