package in.bhavanishankar.minInRotation;

public class Solution {
    public int findMin(int[] nums) {

        int lo = 0, hi = nums.length-1,mid;
        int min = nums[hi];

        // 3,4,5,1,2
        // 4,5,6,7,0,1,2
        // 11,13,15,17
        while (lo <= hi) {
            mid = lo + (hi -lo)/2;

            if (nums[mid] > min) {
                lo = mid + 1;
            } else {
                min = nums[mid];
                hi = mid - 1;
            }
        }

        return min;
    }
}
