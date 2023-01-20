/**
 * https://leetcode.com/problems/longest-palindromic-substring/solution/
 * LONGEST PALINDROMIC SUBSTRING
 */

public class P0005 {
    public String longestPalindrome(String s) {
        if (s.isEmpty() || s.length() < 1)
            return "";
        int start = 0, end = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            int length1 = longestSubstringAtMiddle(s, i, i);
            int length2 = longestSubstringAtMiddle(s, i, i + 1);
            max = Math.max(length1, length2);
            if (max > start - end) {
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int longestSubstringAtMiddle(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left + 1;
    }
}
