package in.bhavanishankar;

import in.bhavanishankar.trappingRain.Solution;

import java.util.Scanner;

public class Main {
    static void main() {
        try(Scanner sc = new Scanner(System.in)) {
            IO.println(String.format("Enter Array Size"));
            int size = sc.nextInt();
            int[] height = new int[size];
            for (int i=0;i<size;++i){
                height[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            IO.println("Trapped water :: "+solution.trap(height));
        } catch (Exception e) {

        }
    }
}
