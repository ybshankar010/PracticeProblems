package in.bhavanishankar.searchRotation;

import java.util.Scanner;

public class Solution {
    public int search(int[] nums, int target) {

        int lo = 0,hi = nums.length-1,mid;

        while (lo <= hi) {
            mid = lo + (hi-lo)/2;

            if(nums[mid] == target) {
                return mid;
            }

            // 4,5,6,7,0,1,2 - 0
            // 4,5,6,7,0,1,2 - 3
            if (nums[lo] <= nums[mid]){
                if ((nums[mid] > target) && (target >= nums[lo])) {
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

        return -1;
    }

    public static void main(String[] args) {

        IO.println("Enter size");
        try (Scanner sc = new Scanner(System.in)) {
            int size = sc.nextInt();
            IO.println("Enter nums :: ");
            int[] nums = new int[size];
            for (int i = 0; i < size; ++i) {
                nums[i] = sc.nextInt();
            }
            IO.println("Enter target :: ");
            int target = sc.nextInt();
            Solution solution = new Solution();
            IO.println("Is target present in the array :: " + solution.search(nums, target));
        } catch (Exception _) {

        }
    }
}
