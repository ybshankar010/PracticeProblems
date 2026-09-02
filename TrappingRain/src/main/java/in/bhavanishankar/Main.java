package in.bhavanishankar;

import in.bhavanishankar.longestValidParanthesis.Solution;

import java.util.Scanner;

public class Main {
    static void main() {
        try(Scanner sc = new Scanner(System.in)) {
            IO.println("Enter Parentheses Size");
            String parentheses = sc.next();

            Solution solution = new Solution();
            IO.println("longest Parentheses length :: "+ solution.longestValidParentheses(parentheses));
        } catch (Exception e) {

        }
    }
}
