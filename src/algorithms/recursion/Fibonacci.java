package algorithms.recursion;

import algorithms.dynamic_programming.DynamicFibonacci;
import data_structure.hash_table.HashMap;

import java.util.ArrayList;

/**
 * Created by Ali Asadi on 08/10/2021
 */

// Given a number N return the index value of the Fibonacci sequence, where the sequence is:
// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...
// the pattern of the sequence is that each value is the sum of the 2 previous values, that means that for N=5 → 2+3
//For example: fibonacciRecursive(6) should return 8

public class Fibonacci {

    int operations = 0;

    int fibonacciIterative(int n) { // O(n)
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);

        for (int i = 2; i <= n; i++) {
            arrayList.add(arrayList.get(i - 1) + arrayList.get(i - 2));
        }

        return arrayList.get(n);

    }

    int fibonacciRecursive(int n) { // O(2^n)
        operations++;

        if (n < 2) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println("Slow: " + fibonacci.fibonacciRecursive(20));
        System.out.println("Slow Operations: " + fibonacci.operations);

        DynamicFibonacci dynamicFibonacci = new DynamicFibonacci();
        System.out.println("DP: " + dynamicFibonacci.dynamicFibonacci(20));
        System.out.println("DP Operations: " + dynamicFibonacci.operations);

//        System.out.println(fibonacci.fibonacciIterative(7));
    }
}
