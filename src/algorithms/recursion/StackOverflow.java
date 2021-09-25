package algorithms.recursion;

/**
 * Created by Ali Asadi on 25/09/2021
 */
public class StackOverflow {

    /**
     * StackOverFlowError Exception (Stack memory is full - no pop operation.)
     *
     **/
    static void recursion() {
        recursion();
    }

    /**
     * Prevent StackOverFlowError Exception (Using a counter)
     **/
    static int counter = 0;
    static void recursionWithCounter() {
        if (counter > 0) {
            return;
        }
        counter++;
        recursionWithCounter();
    }


    /**
     * ### One of the biggest problems/risks of recursion
     * StackOverflow (Infinity Loop) (there is no stop condition) (Stack memory is full)
     * **/
    public static void main(String[] args) {
        recursion();//Exception
        recursionWithCounter();// Prevent Exception
    }
}
