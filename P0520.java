/**
 * https://leetcode.com/problems/detect-capital/
 * DETECT CAPITAL
 */

public class P0520 {
    public boolean method_1(String word) {
        boolean flag = word.charAt(0) >= 'a' ? true : false;
        
        int countUp = 0;
        int countLow = 0;
        for(int i = 1; i < word.length(); i++) {
            if(word.charAt(i) >= 'a') countLow++;
            else countUp++;
        }

        if(flag) {
            return countUp == 0;
        } else {
            return countUp == 0 || countLow == 0;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new P0520().method_1("S"));
    }
}