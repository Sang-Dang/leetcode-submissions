package P0000012;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Submission {

    final ArrayList<String> romans = new ArrayList<>(Arrays.asList("M", "D", "C", "L", "X", "V", "I"));
    final ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1000, 500, 100, 50, 10, 5, 1));

    //O(n)
    private String convertSpecial(int number) {
        StringBuilder result = new StringBuilder();
        for (int i = numbers.size() - 1; i >= 0; i--) {
            if(number < numbers.get(i)) {
                result.append(romans.get(numbers.indexOf(numbers.get(i) - number)));
                result.append(romans.get(i));
                break;
            }
        }
        return result.toString();
    }

    //O(n^2)
    private String convertNormal(int number) {
        StringBuilder result = new StringBuilder();
        while(number > 0) {
            for (int i = 0; i < numbers.size(); i++) {
                if(number - numbers.get(i) >= 0) {
                    result.append(romans.get(i));
                    number -= numbers.get(i);
                    break;
                }
            }
        }
        return result.toString();
    }

    private String convert(List<Integer> splitNumbers) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < splitNumbers.size(); i++) {
            if(Integer.toString(splitNumbers.get(i)).trim().startsWith("4") || Integer.toString(splitNumbers.get(i)).trim().startsWith("9")) {
                result.append(convertSpecial(splitNumbers.get(i)));
            } else {
                result.append(convertNormal(splitNumbers.get(i)));
            }
        }
        return result.toString();
    }

    private List<Integer> parseNumber(int num) {
        ArrayList<Integer> number = new ArrayList<>();
        int power = 0;
        while (num != 0) {
            number.add((num % 10) * (int) Math.pow(10, power++));
            num /= 10;
        }

        Collections.reverse(number);
        return number;
    }

    public String intToRoman(int num) {
        return convert(parseNumber(num));
    }

    public static void main(String[] args) {
        System.out.println(new Submission().intToRoman(144));
    }
}