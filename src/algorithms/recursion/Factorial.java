package algorithms.recursion;

/**
 * Created by Ali Asadi on 25/09/2021
 */

// Write two functions that finds the factorial of any number.
// One should use recursive, the other should just use a for loop
public class Factorial {

    static int findFactorialRecursion(int num) {
        if (num == 2) return 2;
        return findFactorialRecursion(num - 1) * num;
    }

    static int findFactorialIterative(int num) {
        int sum = 1;
        for (int i = 1; i <= num; i++) {
            sum = i * sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(findFactorialRecursion(5));
        System.out.println(findFactorialIterative(5));
    }
}
