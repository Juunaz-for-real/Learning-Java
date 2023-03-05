/*
 * Author: Raick Miranda Rodrigues Santos
 * Registration Number: 781755
 * Objective: TP01Q14 - Practical project from the AEDS II course
 * 
 * \_(*-*)/¨ 
 */

public class TP01Q14 {

    // The main part of the algorithm
    public static void main(String[] args) {
        String[] input = new String[1000];
        int inCounter = 0;
        char firstBool = 0, secondBool = 0, thirdBool = 0;
        String aux = new String();

        // read entries while isEnd is false
        do {
            input[inCounter] = MyIO.readLine();
            inCounter++;
        } while (!isEnd(input[inCounter - 1]));
        inCounter--; // disregard the line 'FIM'

        // For each case stored in the array 'input', change the method according to the
        // number of booleans and print the result
        for (int index = 0; index < inCounter; index++) {
            if (input[index].charAt(0) == '2') {
                firstBool = input[index].charAt(2);
                secondBool = input[index].charAt(4);

                aux = formatInput(input[index], 2, firstBool, secondBool, thirdBool);
                aux = calcsExpression(aux, 0);
            } else if (input[index].charAt(0) == '3') {
                firstBool = input[index].charAt(2);
                secondBool = input[index].charAt(4);
                thirdBool = input[index].charAt(6);

                aux = formatInput(input[index], 3, firstBool, secondBool, thirdBool);
                aux = calcsExpression(aux, 0);
            }

            MyIO.println(aux);
        }

    }

    // Replaces the values of a, b, and c to reduce the string
    private static String formatInput(String in, int n, char firstBool, char secondBool, char thirdBool) {
        String answer = "";

        if (n == 3)
            for (int index = 8; index < in.length(); index++) {
                if (index == in.length() - 1 && in.charAt(index) == ' ') {
                    answer += "";
                } else if (in.charAt(index) == 'A') {
                    answer += firstBool;
                } else if (in.charAt(index) == 'B') {
                    answer += secondBool;
                } else if (in.charAt(index) == 'C') {
                    answer += thirdBool;
                } else {
                    answer += in.charAt(index);
                }
            }
        else if (n == 2)
            for (int index = 6; index < in.length(); index++) {
                if (in.charAt(index) == 'A') {
                    answer += firstBool;
                } else if (in.charAt(index) == 'B') {
                    answer += secondBool;
                } else if (in.charAt(index) == 'C') {
                    answer += thirdBool;
                } else {
                    answer += in.charAt(index);
                }
            }

        return answer;
    }

    // Calculates the result of the expression from the previous formatting,
    // recursively
    private static String calcsExpression(String in, int i) {
        String answer = "";
        i = in.length();

        // as long as "i" is not equal to "1", call replace
        if (i == 1) {
            return in;
        } else {
            in = replace(in);
            answer = calcsExpression(in, in.length());
        }

        return answer;
    }

    // Replacing expressions to reduce the problem, for this call "replace" and pass
    // the old string
    private static String replace(String in) {
        in = replace("not(0)", "1", in);
        in = replace("not(1)", "0", in);
        in = replace("and(0 , 0", "and(0", in);
        in = replace("and(0 , 1", "and(0", in);
        in = replace("and(1 , 0", "and(0", in);
        in = replace("and(1 , 1", "and(1", in);
        in = replace("and(0)", "0", in);
        in = replace("and(1)", "1", in);
        in = replace("or(0 , 0", "or(0", in);
        in = replace("or(0 , 1", "or(1", in);
        in = replace("or(1 , 0", "or(1", in);
        in = replace("or(1 , 1", "or(1", in);
        in = replace("or(1, 1", "or(1", in);
        in = replace("or(1, 0", "or(1", in);
        in = replace("or(0, 1", "or(1", in);
        in = replace("or(0, 0", "or(0", in);
        in = replace("or(0)", "0", in);
        in = replace("or(1)", "1", in);

        return in;
    }

    // Replaces the old string with the new version until all are replaced
    private static String replace(String old, String replaced, String in) {
        String answer = "";
        int indexof = getIndex(old, in);

        if (indexof != -1) {
            for (int index = 0; index < indexof; index++) {
                answer += in.charAt(index);
            }

            answer += replaced;

            for (int index = indexof + old.length(); index < in.length(); index++) {
                answer += in.charAt(index);
            }

            if (getIndex(old, answer) != -1) {
                return replace(old, replaced, answer);
            }
        } else {
            return in;
        }

        return answer;
    }

    // Returns the index within this string of the first occurrence of the specified
    // substring
    private static int getIndex(String substr, String in) {
        int length = in.length(), lengthSub = substr.length(), counter = 0;

        if (lengthSub > length) {
            return -1;
        }

        for (int index = 0; index < length - lengthSub + 1; index++) {
            for (int i = 0; i < lengthSub; i++) {
                if (in.charAt(index + i) == substr.charAt(i)) {
                    counter++;

                    if (counter == lengthSub) {
                        return index;
                    }
                } else {
                    counter = 0;
                    i = lengthSub;
                }
            }
        }

        return -1;
    }

    // If the input reads '0', stop reading and skip the algorithm to the next part
    private static boolean isEnd(String in) {
        return (in.length() >= 1 && in.charAt(0) == '0');
    }

}