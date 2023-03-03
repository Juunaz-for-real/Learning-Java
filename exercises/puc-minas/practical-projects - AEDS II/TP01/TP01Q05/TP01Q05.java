/*
 * Author: Raick Miranda Rodrigues Santos
 * Registration Number: 781755
 * Objective: TP01Q05 - Practical project from the AEDS II course
 * 
 * \_(*-*)/¨ 
 */

public class TP01Q05 {

    // The main part of the algorithm
    public static void main(String[] args) {
        String input = MyIO.readLine();

        // read entries while isEnd is false
        while (!isEnd(input)) {
            input = formatInput(input);

            while (input.length() != 1) {
                input = selectOperator(input);
            }
            MyIO.println(input);
            input = MyIO.readLine();
        }
    }

    // Input formatting
    private static String formatInput(String in) {
        return replaceOperand(removePeriod(in));
    }

    // Exchanges boolean variables
    private static String replaceOperand(String in) {
        String answer = "";
        int index, j;
        int operandValue = (int) (in.charAt(0) - 48);
        int[] operand = new int[operandValue];

        j = 1;
        for (index = 0; index < operandValue; index++) {
            operand[index] = (int) (in.charAt(j) - 48);
            j++;
        }

        // as long as the string length is not reached, test each character
        j = 0;
        for (index = operandValue + 1; index < in.length(); index++) {
            if (in.charAt(index) >= 'A' && in.charAt(index) <= 'Z') {
                j = (int) (in.charAt(index) - 65);
                answer += operand[j];
            } else
                answer += in.charAt(index);
        }

        return answer;
    }

    // Remove periods and commas
    private static String removePeriod(String in) {
        String answer = "";

        // as long as the string length is not reached, test each character
        for (int index = 0; index < in.length(); index++) {
            if (in.charAt(index) == 'a' || in.charAt(index) == 'n') {
                answer += in.charAt(index);
                index += 2;
            } else if (in.charAt(index) == 'o') {
                answer += in.charAt(index);
                index += 1;
            } else if (in.charAt(index) != ' ' && in.charAt(index) != ',') {
                answer += in.charAt(index);
            }
        }

        return answer;
    }

    // Get the index of the last opening parenthesis
    private static int getLastPart(String in) {
        int answer = 0;

        // as long as the string length is not reached, test each character
        for (int index = 0; index < in.length(); index++) {
            if (in.charAt(index) == '(')
                answer = index;
        }

        return answer;
    }

    // Toggles between operators
    private static String selectOperator(String in) {
        String answer = "";

        int lastPart = getLastPart(in);
        char operator = in.charAt(lastPart - 1);

        switch (operator) {
            case 'a':
                answer = operationAnd(lastPart, in);
                break;

            case 'o':
                answer = operationOr(lastPart, in);
                break;

            case 'n':
                answer = operationNot(lastPart, in);
                break;
        }

        return answer;
    }

    // Calculates the operation AND
    private static String operationAnd(int part, String in) {
        String answer = "";
        char result;

        boolean[] operands = new boolean[5];
        int index = 0;

        // stores the operands in the array
        for (int i = part + 1; i < in.length(); i++) {
            if (in.charAt(i) != ')') {
                operands[index] = convertToBool(in.charAt(i));
                index++;
            } else
                i = in.length();
        }

        // comparing operands
        if (index == 3) {
            if (operands[0] && operands[1] && operands[2])
                result = '1';
            else
                result = '0';
        } else {
            if (operands[0] && operands[1])
                result = '1';
            else
                result = '0';

        }

        // replacement
        for (int counter = 0; counter < in.length(); counter++) {
            if (counter != part - 1)
                answer += in.charAt(counter);
            else {
                answer += result;
                counter += (index + 3) - 1;
            }
        }

        return answer;
    }

    // Calculates the operation NOT
    private static String operationNot(int part, String in) {
        String answer = "";
        char result;

        if (in.charAt(part + 1) == '0')
            result = '1';
        else
            result = '0';

        // replacement
        for (int counter = 0; counter < in.length(); counter++) {
            if (counter != part - 1)
                answer += in.charAt(counter);
            else {
                answer += result;
                counter += 3;
            }
        }

        return answer;
    }

    // Calculates the operation OR
    private static String operationOr(int part, String in) {
        String answer = "";
        char result = '0';

        boolean[] operands = new boolean[5];
        int index = 0;

        // stores the operands in the array
        for (int i = part + 1; i < in.length(); i++) {
            if (in.charAt(i) != ')') {
                operands[index] = convertToBool(in.charAt(i));
                index++;
            } else
                i = in.length();
        }

        // comparing operands
        for (int i = 0; i < index; i++) {
            if (operands[i] == true)
                result = '1';
        }

        // replacement
        for (int counter = 0; counter < in.length(); counter++) {
            if (counter != part - 1)
                answer += in.charAt(counter);
            else {
                answer += result;
                counter += (index + 3) - 1;
            }
        }

        return answer;
    }

    // converts the character to boolean
    private static boolean convertToBool(char in) {
        boolean answer = false;

        if (in == '1')
            answer = true;

        return answer;
    }

    // If the input reads '0, stop reading and skip the algorithm to the next part
    private static boolean isEnd(String in) {
        return (in.length() >= 1 && in.charAt(0) == '0');
    }

}