/*
 * Author: Raick Miranda Rodrigues Santos
 * Registration Number: 781755
 * Objective: TP01Q13 - Practical project from the AEDS II course
 * 
 * \_(*-*)/¨ 
 */

public class TP01Q13 {

    // The main part of the algorithm
    public static void main(String[] args) {
        String[] input = new String[1000];
        int inCounter = 0;

        // read entries while isEnd is false
        do {
            input[inCounter] = MyIO.readLine();
        } while (!isEnd(input[inCounter++]));
        inCounter--; // disregard the line 'FIM'

        // calls Cesar encryption to each line of the array 'input'
        for (int index = 0; index < inCounter; index++) {
            encryption(input[index]);
            System.out.println();
        }

    }

    // Applies Cesar encryption to the received string
    private static void encryption(String in) {
        encryption(in, 0);
    }

    // Applies Cesar encryption to the received string, recursively
    private static void encryption(String in, int index) {

        // checks the internal commands as long as the index is smaller than the string
        // length
        if (index < in.length()) {
            MyIO.print((char) (in.charAt(index) + 3));
            encryption(in, index + 1);
        }

    }

    // If the input reads the word 'FIM', stop reading and skip the algorithm to the
    // next part
    private static boolean isEnd(String in) {
        return in.length() == 3 && in.charAt(0) == 'F' && in.charAt(1) == 'I' && in.charAt(2) == 'M';
    }

}