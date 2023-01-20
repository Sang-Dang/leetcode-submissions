/**
 * https://leetcode.com/problems/search-insert-position/
 * SEARCH INSERT POSITION
 */

public class P0035 {
    public static int searchInsert(int[] nums, int target) {
        if(nums.length == 0) 
            return 0;
        int returnVal = binarySearch(nums, target, 0, nums.length - 1);
        return returnVal == -1 ? 0 : returnVal;
    }

    private static int binarySearch(int[] num, int target, int start, int end) {
        // definitely breaking out here
        if (start == end) {
            if (target > num[start])
                return start + 1;
            if (target < num[start])
                return start - 1;
            else
                return start;
        }

        if(start + 1 == end) {
            if(target < num[start])
                return start - 1;
            else if(target > num[end])
                return end + 1;
            else if(target > num[start] && target < num[end])
                return end;
            else 
                return target == num[start] ? start : end;
        }

        int middle = start + (end - start) / 2;
        if (target > num[middle]) {
            return binarySearch(num, target, middle, end);
        } else if (target < num[middle]) {
            return binarySearch(num, target, start, middle);
        } else {
            return middle;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int target = 0;
        System.out.println(searchInsert(nums,target));
    }
}
