package in.bhavanishankar.searchRotation2;

import java.util.Scanner;

public class Solution {
    public boolean search(int[] nums, int target) {

        int lo = 0,hi = nums.length-1,mid;

        while (lo <= hi) {
            mid = lo +(hi-lo)/2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[lo] == nums[mid]) {
                ++lo;
                continue;
            }

            if (nums[lo] < nums[mid]) {
                if ((nums[lo] <= target) && (target < nums[mid])) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if ((nums[mid] < target) && (target <= nums[hi])) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        IO.println("Enter size");
        try (Scanner sc = new Scanner(System.in)) {
            int size = sc.nextInt();
            IO.println("Enter nums :: ");
            int[] nums = new int[size];
            for (int i = 0;i<size;++i) {
                nums[i] = sc.nextInt();
            }
            IO.println("Enter target :: ");
            int target = sc.nextInt();
            Solution solution = new Solution();
            IO.println("Is target present in the array :: "+solution.search(nums,target));
        } catch (Exception _){

        }

    }
}
