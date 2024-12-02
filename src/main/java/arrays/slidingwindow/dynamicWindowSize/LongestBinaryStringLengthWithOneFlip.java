package arrays.slidingwindow.dynamicWindowSize;

/*
You are given a binary string s (a string containing only "0" and "1").
You may choose up to one "0" and flip it to a "1".
 What is the length of the longest substring achievable that contains only "1"?

 --> Reword the problem as length of the longest substring/subarray which contains atmost one zero
 */

public class LongestBinaryStringLengthWithOneFlip {
    private static int longestBinaryStringLengthWithOneFlip(final String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        int left = 0;
        int countOfZerosSoFar = 0;
        int maxWindowLengthWithAtmostOneZero = 0;

        for (int right = 0; right < n; right++) {
            if (chars[right] == '0') {
                countOfZerosSoFar++;
            }
            while (countOfZerosSoFar > 1 && left < n) {
                if(chars[left] == '0') {
                    countOfZerosSoFar -= 1;
                }
                left++;
            }
            if (countOfZerosSoFar <= 1) {
                maxWindowLengthWithAtmostOneZero = Math.max(maxWindowLengthWithAtmostOneZero, right - left + 1);
            }
        }
        return maxWindowLengthWithAtmostOneZero;
    }

    public static void main(String[] args) {
        String s1 = "0000";
        String s2 = "1111";
        String s3 = "1011";
        String s4 = "1001";
        String s5 = "1101100111";
        System.out.println(longestBinaryStringLengthWithOneFlip(s1));
        System.out.println(longestBinaryStringLengthWithOneFlip(s2));
        System.out.println(longestBinaryStringLengthWithOneFlip(s3));
        System.out.println(longestBinaryStringLengthWithOneFlip(s4));
        System.out.println(longestBinaryStringLengthWithOneFlip(s5));
    }
}
