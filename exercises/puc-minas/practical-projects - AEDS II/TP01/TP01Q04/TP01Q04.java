/*
 * Author: Raick Miranda Rodrigues Santos
 * Registration Number: 781755
 * Objective: TP01Q04 - Practical project from the AEDS II course
 * 
 * \_(*-*)/¨ 
 */

// Imported Libraries
import java.util.Random;

public class TP01Q04 {

    // The main part of the algorithm
    public static void main(String[] args) {
        String[] input = new String[1000];
        int inCounter = 0;

        // read entries while isEnd is false
        do {
            input[inCounter] = MyIO.readLine();
        } while (!isEnd(input[inCounter++]));
        inCounter--; // disregard the line 'FIM'

        // Instantiating the class Random
        Random generator = new Random();
        generator.setSeed(4);

        // setting the random change and calling the method for each line of the array
        // 'input'
        for (int index = 0; index < inCounter; index++) {
            char firstChar = (char) ('a' + Math.abs(generator.nextInt() % 26));
            char secondChar = (char) ('a' + Math.abs(generator.nextInt() % 26));
            MyIO.println(randomChange(input[index], firstChar, secondChar));
        }

    }

    // takes a string and changes the selected characters
    private static String randomChange(String in, char firstChar, char secondChar) {
        String answer = "";

        // as long as the string length is not reached, test each character
        for (int index = 0; index < in.length(); index++) {

            // if it's the drawn character, then change
            if (in.charAt(index) == firstChar)
                answer += secondChar;
            else // otherwise, keep
                answer += in.charAt(index);
        }

        return answer;
    }

    // If the input reads the word 'FIM', stop reading and skip the algorithm to the
    // next part
    private static boolean isEnd(String in) {
        return in.length() == 3 && in.charAt(0) == 'F' && in.charAt(1) == 'I' && in.charAt(2) == 'M';
    }

}