package algorithms.dynamic_programming;

import data_structure.hash_table.HashMap;

/**
 * Created by Ali Asadi on 06/11/2021
 */
public class DynamicFibonacci {
    private final HashMap<Integer, Integer> cache = new HashMap<>();
    public int operations = 0;

    public int dynamicFibonacci(int n) {
        if (cache.get(n) != null) {
            return cache.get(n);
        }
        if(n < 2){
            return n;
        }
        operations++;
        cache.put(n, dynamicFibonacci(n - 1) + dynamicFibonacci(n - 2));
        return cache.get(n);
    }

    public static void main(String[] args) {
        System.out.println(new DynamicFibonacci().dynamicFibonacci(10));
    }
}
