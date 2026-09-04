package in.bhavanishankar.minElementRotatedBinSearch;

import java.util.Scanner;

public class Solution {
    public int findMin(int[] nums) {

        int lo = 0,hi=nums.length-1,mid;
        int min = nums[hi];

        while (lo < hi) {
            mid = lo + (hi-lo)/2;

            // 3 4 5 1 2
            // 4,5,6,7,0,1,2
            // 1,2,3,4,5
            // 5,4,3,2,1
            if (nums[mid] > min) {
                lo = mid + 1;
            } else {
                hi = mid;
            }

        }

        return nums[lo];
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
            Solution solution = new Solution();
            IO.println("Min Element in the array :: " + solution.findMin(nums));
        } catch (Exception _) {

        }
    }
}
