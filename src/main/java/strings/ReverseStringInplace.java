package strings;

public class ReverseStringInplace {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int i = 0, j = s.length - 1;
        char temp;
        while (i < j) {
            if (s[i] != s[j]) {
                temp = s[i];
                s[i] = s[j];
                s[j] = temp;
            }
            i++;
            j--;
        }
    }
}
