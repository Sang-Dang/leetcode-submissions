/**
 * https://leetcode.com/problems/capitalize-the-title/
 * CAPITALIZE THE TITLE
 */
public class P2129 {

    private String toCamelCase(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append((char)(s.charAt(0) - 32));
        sb.append(s.substring(1));
        return sb.toString();
    }

    /**
     * split string into parts. Check each part for length. 
     * if larger than 2 then convert into camelcase and add to
     * stringbuilder. 
     * @param s input string
     * @return formatted string
     */
    public String method_1(String s) {
        String[] parts = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].toLowerCase().trim();
            if(parts[i].length() > 2) {
                sb.append(toCamelCase(parts[i]));
            } else {
                sb.append(parts[i]);
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }


    public String method_2(String s) {
        s = s.toLowerCase();

        int start = 0;
        int length = 0;
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                if(length > 2) {
                    result.replace(start,start+1,Character.toString((char)(result.charAt(start) - 32)));
                }
                start = i + 1;
                result.append(" ");
                length = 0;
            } else {
                length++;
                result.append(s.charAt(i));
            }
        }
        if(length > 2) {
            result.replace(start,start+1,Character.toString((char)(result.charAt(start) - 32)));
        }

        return result.toString();

    }

    public static void main(String[] args) {
        System.out.println(new P2129().method_2("the meaniNg of LIFE is amAzing af"));
    }
}
