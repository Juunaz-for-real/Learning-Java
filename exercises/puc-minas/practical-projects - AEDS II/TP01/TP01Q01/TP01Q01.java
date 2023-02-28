/*
 * Author: Raick Miranda Rodrigues Santos
 * Registration Number: 781755
 * Objective: TP01Q01 - Practical project from the AEDS II course
 * 
 * \_(*-*)/¨ 
 */

public class TP01Q01 {

    // The main part of the algorithm
    public static void main(String[] args) throws Exception {
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
        boolean answer = false;

        // compares the first character with the last until the counter reaches the
        // midpoint
        for (int i = 0, j = in.length() - 1; i < in.length() / 2; i++, j--) {
            if (in.charAt(i) == in.charAt(j))
                answer = true;
            else { // if it's different, then it is not a palindrome; stop then
                answer = false;
                break;
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
