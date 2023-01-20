// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS

import java.util.HashSet;

public class P0003 {

    /**
     * Doesn't work
     * @param s
     * @return
     */
    public int brute_force(String s) {
        if(s.length() == 1) {
            return 1;
        }

        if(s.isEmpty()) {
            return 0;
        }
        HashSet<Character> buffer = new HashSet<>();
        int length = 0;
        int currentStart = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!buffer.contains(s.charAt(i))) {
                buffer.add(s.charAt(i));
            } else {
                if (buffer.size() > length) 
                    length = buffer.size();
                buffer.clear();
                i = currentStart + 1;
                currentStart = i;
                buffer.add(s.charAt(i));
            }
        }

        return buffer.size() > length ? buffer.size() : length;
    }

    public int brute_force_2(String s) {
        StringBuilder formatted = new StringBuilder();
        HashSet<Character> buffer = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            if(!buffer.contains(s.charAt(i))) {
                buffer.add(s.charAt(i));
                formatted.append(s.charAt(i));
            } else {
                formatted.append(".");
            }
        }
        System.out.println(formatted.toString());
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new P0003().brute_force("anviaj"));
    }
}
