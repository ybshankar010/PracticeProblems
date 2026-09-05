package in.bhavanishankar.search2D;

import java.util.Scanner;

public class Solution {
    private boolean binarySearch(int[] nums, int target) {
        int lo = 0, hi = nums.length-1,mid;

        while (lo <= hi) {
            mid = lo + (hi-lo)/2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }

        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length,cols = matrix[0].length;

        int lo = 0, hi = rows-1,mid;
        while (lo <= hi) {
            mid = lo + (hi-lo)/2;

            if (matrix[mid][0] == target) {
                return true;
            }

            if (matrix[mid][0] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return hi>=0 &&binarySearch(matrix[hi],target);
    }

    static void main() {
        try(Scanner sc = new Scanner(System.in)) {
            IO.println("Enter # rows and # cols");
            int rows = sc.nextInt(),cols = sc.nextInt();
            int[][] matrix = new int[rows][cols];

            for (int i=0;i<rows;++i) {
                for (int j=0;j<cols;++j) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            IO.println("Enter target :: ");
            int target = sc.nextInt();

            Solution solution = new Solution();
            IO.println("Present in the array :: "+solution.searchMatrix(matrix,target));

        } catch (Exception _) {

        }
    }
}
