/*
 * Author: Raick Miranda Rodrigues Santos
 * Registration Number: 781755
 * Objective: TP01Q06 - Practical project from the AEDS II course
 * 
 * \_(*-*)/¨ 
 */

public class TP01Q06 {

    // The main part of the algorithm
    public static void main(String[] args) {
        String[] input = new String[1000];
        int inCounter = 0;

        // read entries while isEnd is false
        do {
            input[inCounter] = MyIO.readLine();
        } while (!isEnd(input[inCounter++]));
        inCounter--; // disregard the line 'FIM'

        // calls each test method for each line stored in the array 'input'
        for (int index = 0; index < inCounter; index++) {
            System.out.print(isVowel(input[index]) ? "SIM " : "NAO ");
            System.out.print(isConsonant(input[index]) ? "SIM " : "NAO ");
            System.out.print(isInteger(input[index]) ? "SIM " : "NAO ");
            System.out.println(isReal(input[index]) ? "SIM" : "NAO");
        }

    }

    // Get a character and tell if it's a vowel
    private static boolean isVowel(char in) {
        return in == 65 || in == 69 || in == 73 || in == 79 || in == 85
                || in == 97 || in == 101 || in == 105 || in == 111 || in == 117;
    }

    // Get a character and tells whether it is in the range of the Latin Alphabet
    // according to the ASCII table
    private static boolean isInAlphabetRange(char in) {
        return (in >= 65 && in <= 90) || (in >= 97 && in <= 122);
    }

    // Get a character and tells if it's in the range of numbers according to the
    // ASCII table
    private static boolean isInNumbersRange(char in) {
        return (in >= 48 && in <= 57);
    }

    // Takes a string and says whether it is formed only by vowels
    private static boolean isVowel(String in) {
        boolean answer = true;

        // as long as the string length is not reached, test each character
        for (int index = 0; index < in.length(); index++) {

            // if the character is not a vowel or is not in the range of the Latin Alphabet,
            // stop as it doesn't meet the requirements to be formed from vowels only
            if (!isVowel(in.charAt(index)) || !isInAlphabetRange(in.charAt(index))) {
                answer = false;
                break;
            }
        }

        return answer;
    }

    // Takes a string and says whether it is formed only by consonants
    private static boolean isConsonant(String in) {
        boolean answer = true;

        // as long as the string length is not reached, test each character
        for (int index = 0; index < in.length(); index++) {

            // if the character is a vowel or is not in the range of the Latin alphabet,
            // stop as it does not meet the requirements to be formed from consonants only
            if (isVowel(in.charAt(index)) || !isInAlphabetRange(in.charAt(index))) {
                answer = false;
                break;
            }
        }

        return answer;
    }

    // Takes a string and says whether it is formed only by an integer number
    private static boolean isInteger(String in) {
        boolean answer = true;

        // as long as the string length is not reached, test each character
        for (int index = 0; index < in.length(); index++) {

            // if the character is not a number, then stop as it doesn't meet the
            // requirements to be formed by an integer only
            if (!isInNumbersRange(in.charAt(index))) {
                answer = false;
                break;
            }
        }

        return answer;
    }

    // Takes a string and says whether it is formed only by a real number
    private static boolean isReal(String in) {
        boolean answer = true;
        int aux = 0; // to count periods and commas

        // as long as the string length is not reached, test each character
        for (int index = 0; index < in.length(); index++) {

            // increase the 'aux' counter if the character is a period or a comma
            if (in.charAt(index) == 44 || in.charAt(index) == 46) {
                aux++;
            }

            // if more than one period or comma is counted, then stop because it's not a
            // real number
            if (aux > 1) {
                answer = false;
                break;
            }

            // if the character isn't in range of numbers or isn't a period or a comma, then
            // stop as it doesn't meet the requirements to be a real number only
            if (!isInNumbersRange(in.charAt(index)) && in.charAt(index) != 44 && in.charAt(index) != 46) {
                answer = false;
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