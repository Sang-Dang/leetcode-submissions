// https://leetcode.com/problems/length-of-last-word/
// LENGTH OF LAST WORD

public class P0058 {
    public int method_1(String s) {
        String[] parts = s.split(" ");
        return parts[parts.length - 1].length();
    }

    public int method_2(String s) {
        int count = 0;
        int i = s.length() - 1;
        while(s.charAt(i) == ' ') i--;

        for(; i >= 0 && s.charAt(i) != ' '; i--) 
            count++;
        
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new P0058().method_2("ab"));
    }
}
