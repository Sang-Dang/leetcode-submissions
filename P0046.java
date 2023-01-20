
/**
 * https://leetcode.com/problems/permutations/
 * PERMUTATIONS
 */

/**
 * IN PROGRESS
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("all")
public class P0046 {

    

    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(num.length == 1) {
            result.add(Arrays.asList(num[0]));
            return result;
        }

        for(int i = 0; i < num.length; i++) {
            int temp = num[i];
            List<List<Integer>> splitted = permute(split(num,i));
            for(List<Integer> j: splitted) {
                result.add(j);
                
            }
        }
        return result;
    }

    private int[] split(int[] num, int except) {
        int[] result = new int[num.length];
        int j = 0;
        for(int i = 0; i < num.length; i++) {
            if(i != except) {
                result[j] = num[i];
                j++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] list = {1,2,3};
        System.out.println(new P0046().permute(list));
    }
}