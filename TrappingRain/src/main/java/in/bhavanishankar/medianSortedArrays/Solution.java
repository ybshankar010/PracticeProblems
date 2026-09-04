package in.bhavanishankar.medianSortedArrays;

import java.util.Scanner;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length,mid = totalLength/2;
        int[] medianArr = new int[mid+1];

        int idx = 0,i =0,j=0;

        while (i < nums1.length && j < nums2.length && idx < medianArr.length) {
            if (nums1[i] <= nums2[j]) {
                medianArr[idx] = nums1[i];
                ++i;
            } else {
                medianArr[idx] = nums2[j];
                ++j;
            }
            ++idx;
        }

        if (idx < medianArr.length && i < nums1.length) {
            while (idx < medianArr.length && i < nums1.length) {
                medianArr[idx] = nums1[i];
                ++i;
                ++idx;
            }
        }

        if (idx < medianArr.length && j < nums2.length) {
            while (idx < medianArr.length && j < nums2.length) {
                medianArr[idx] = nums2[j];
                ++j;
                ++idx;
            }
        }

        if (totalLength %2 == 0) {
            return (medianArr[medianArr.length-1] + medianArr[medianArr.length-2]) /2.d;
        }

        return medianArr[medianArr.length-1];
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            IO.println("Enter size");
            int size = sc.nextInt();
            IO.println("Enter nums1 :: ");
            int[] nums1 = new int[size];
            for (int i = 0; i < size; ++i) {
                nums1[i] = sc.nextInt();
            }

            IO.println("Enter size");
            size = sc.nextInt();
            IO.println("Enter nums2 :: ");
            int[] nums2 = new int[size];
            for (int i = 0; i < size; ++i) {
                nums2[i] = sc.nextInt();
            }
            Solution solution = new Solution();
            IO.println("Median of the array :: " + solution.findMedianSortedArrays(nums1, nums2));
        } catch (Exception _) {

        }
    }
}
