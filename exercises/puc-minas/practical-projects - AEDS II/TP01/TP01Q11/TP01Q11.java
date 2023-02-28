/*
 * Author: Raick Miranda Rodrigues Santos
 * Registration Number: 781755
 * Objective: TP01Q11 - Practical project from the AEDS II course
 * 
 * \_(*-*)/¨ 
 */

public class TP01Q11 {

    // The main part of the algorithm
    public static void main(String[] args) {
        String[] input = new String[1000];
        int inCounter = 0;

        // read entries while isEnd is false
        do {
            input[inCounter] = MyIO.readLine();
        } while (!isEnd(input[inCounter++]));
        inCounter--; // disregard the line 'FIM'

        // calls isPalindrome for each line stored in the array 'input'
        for (int index = 0; index < inCounter; index++) {
            System.out.println(isPalindrome(input[index]) ? "SIM" : "NAO");
        }

    }

    // Receives a string and tells whether it is a palindrome or not
    private static boolean isPalindrome(String in) {
        return isPalindrome(in, 0, in.length() - 1);
    }

    // Receives a string and tells whether it is a palindrome or not, recursively
    private static boolean isPalindrome(String in, int left, int right) {
        boolean answer = true;

        // checks the internal conditionals as long as the left index is smaller than
        // the right one
        if (left < right) {

            // if the comparison between the characters results in a difference, then it is
            // not a palindrome
            if (in.charAt(left) != in.charAt(right)) {
                answer = false;
            } else {
                answer = isPalindrome(in, left + 1, right - 1);
            }
        }

        return answer;
    }

    // If the input reads the word 'FIM', stop reading and skip the algorithm to the
    // next part
    private static boolean isEnd(String in) {
        return in.length() == 3 && in.charAt(0) == 'F' && in.charAt(1) == 'I' && in.charAt(2) == 'M';
    }

}