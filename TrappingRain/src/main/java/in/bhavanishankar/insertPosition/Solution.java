package in.bhavanishankar.insertPosition;

public class Solution {
    public int searchInsert(int[] nums, int target) {

        int lo =0,hi = nums.length-1,mid;

        while (lo <= hi) {
            mid = lo + (hi-lo)/2;

            if (nums[mid] == target) {
                return mid;
            }

            // 1,2,3,4,5 - 6
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }

        }


        return lo;
    }
}
