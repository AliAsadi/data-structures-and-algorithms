package data_structure.arrays.questions;

public class Reverse {

    //Create a function that reverses a a string.
    public static void main(String[] args) {
        reverse("Hi My name is Ali");
    }

    //1. Check Input
    public static void reverse(String string) {
        if (string != null && !string.isEmpty()) {

            char[] chars = string.toCharArray();

            for (int i = chars.length - 1; i >= 0; i--) {
                System.out.print(chars[i]);
            }
        }
    }

    public static void reverse2(String string) {
        if (string != null && !string.isEmpty()) {
            for (int i = string.length() - 1; i >= 0; i--) {
                System.out.print(string.charAt(i));
            }
        }
    }

    public static void reverse3(String string) {
        if (string != null && !string.isEmpty()) {
            System.out.print(new StringBuilder(string).reverse().toString());
        }
    }
}
