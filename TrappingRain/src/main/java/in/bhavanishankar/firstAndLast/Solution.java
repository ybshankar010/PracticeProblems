package in.bhavanishankar.firstAndLast;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {


    private int findBound(int[] nums, int target, int lo, int hi, boolean isFirst) {

        int mid;

        while (lo <= hi) {

            mid = lo + (hi - lo) /2;

            if (nums[mid] == target) {
                if (isFirst) {
                    if (mid == lo || nums[mid - 1] != target) {
                        return mid;
                    }
                    hi = mid - 1;
                } else {
                    if (mid == hi || nums[mid+1] != target) {
                        return mid;
                    }
                    lo = mid + 1;
                }
            }else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }

        }

        return -1;
    }

    public int[] searchRange(int[] nums, int target) {

        int [] positions = new int[2];
        positions[0] = findBound(nums,target,0,nums.length-1,true);
        if (positions[0] != -1){
            positions[1] = findBound(nums,target,0,nums.length-1,false);
        } else {
            positions[1] = -1;
        }

        return positions;
    }

    static void main() {
        try(Scanner sc = new Scanner(System.in)) {
            IO.println("size of array :: ");
            int size = sc.nextInt();
            IO.println("Enter array :: ");
            int[] nums = new int[size];
            for(int i =0 ;i<size;++i) {
                nums[i] = sc.nextInt();
            }
            IO.println("enter target :: ");
            int target = sc.nextInt();
            Solution solution = new Solution();
            IO.println("Available at positions :: "+ Arrays.toString(solution.searchRange(nums, target)));
        } catch (Exception _) {

        }
    }
}
