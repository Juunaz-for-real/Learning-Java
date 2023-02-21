/*
 * Author: Raick Miranda Rodrigues Santos
 * Registration Number: 781755
 * Objective: TP01Q08 - Practical project from the AEDS II course
 * 
 * \_(*-*)/¨ 
 */

// Imported Libraries
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class TP01Q08 {

    // The main part of the algorithm
    public static void main(String[] args) throws IOException {
        String[] webpage = new String[100], urlAdress = new String[100];
        int inCounter = 0;

        // read entries while isEnd is false
        webpage[inCounter] = MyIO.readLine();
        do {
            urlAdress[inCounter] = MyIO.readLine();
            inCounter++;
            webpage[inCounter] = MyIO.readLine();
        } while (!isEnd(webpage[inCounter]));

        // for each url read, evaluate the html
        String html = "";
        for (int index = 0; index < inCounter; index++) {
            html = getHtml(urlAdress[index]);
            evaluateHtml(html, webpage[index]);
        }

    }

    // Reads the HTML page from the url adreess
    public static String getHtml(String address) {
        String answer = "", line;
        URL url;
        InputStream is = null;
        BufferedReader br;

        // wraps objects from public classes to handle possible errors
        try {

            // creates a new variable from the url address and uses it in the public read
            // classes
            url = new URL(address);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            // populates the return string with the contents present in the html while null
            // is not reached

            while ((line = br.readLine()) != null)
                answer += (line + "\n");

            // prints a message in case of error
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        // wraps to handle possible errors
        try {
            is.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return answer; // return the string with the html
    }

    // HTML tag detection for counting
    private static int getTag(String html, String tag) {
        int answer = 0;

        // if its a line break tag, increase
        if (tag == "<br>") {
            for (int index = 0; index < html.length(); index++)
                if (html.charAt(index) == '<')
                    if (html.charAt(index + 1) == 'b' && html.charAt(index + 2) == 'r'
                            && html.charAt(index + 3) == '>')
                        answer++;
        } else { // if its a table tag, increase
            for (int index = 0; index < html.length(); index++)
                if (html.charAt(index) == '<')
                    if (html.charAt(index + 1) == 't' && html.charAt(index + 2) == 'a'
                            && html.charAt(index + 3) == 'b' && html.charAt(index + 4) == 'l'
                            && html.charAt(index + 5) == 'e' && html.charAt(index + 6) == '>')
                        answer++;
        }

        return answer;
    }

    // Get a character and tell if it's a vowel
    private static boolean isVowel(char in) {
        return in == 97 || in == 101 || in == 105 || in == 111 || in == 117;
    }

    // Get a character and tells whether it is in the range of the Latin Alphabet
    // according to the ASCII table
    private static boolean isInAlphabetRange(char in) {
        return (in >= 97 && in <= 122);
    }

    // Does the conversion to print the char according to the charset
    private static String printChar(String in) {
        byte[] b = in.getBytes();
        String answer = new String(b, StandardCharsets.ISO_8859_1);

        return answer;
    }

    // Evaluates the html for the requested count, then prints them
    private static void evaluateHtml(String html, String webpage) {
        int[] answer = new int[25];

        // as long as the end of the string containing the html isn't reached, evaluates
        // each char
        for (int index = 0; index < html.length(); index++) {

            // if it's in the range of the Latin Alphabet, but isn't a vowel, increment the
            // consonant counter
            if (isInAlphabetRange(html.charAt(index)) && (!isVowel(html.charAt(index))))
                answer[22]++;

            // counters for the remaining characters
            else
                switch (html.charAt(index)) {
                    case 'a':
                        answer[0]++;
                        break;

                    case 'e':
                        answer[1]++;
                        break;

                    case 'i':
                        answer[2]++;
                        break;

                    case 'o':
                        answer[3]++;
                        break;

                    case 'u':
                        answer[4]++;
                        break;

                    case '\u00E1':
                        answer[5]++;
                        break;

                    case '\u00E9':
                        answer[6]++;
                        break;

                    case '\u00ED':
                        answer[7]++;
                        break;

                    case '\u00F3':
                        answer[8]++;
                        break;

                    case '\u00FA':
                        answer[9]++;
                        break;

                    case '\u00E0':
                        answer[10]++;
                        break;

                    case '\u00E8':
                        answer[11]++;
                        break;

                    case '\u00EC':
                        answer[12]++;
                        break;

                    case '\u00F2':
                        answer[13]++;
                        break;

                    case '\u00F9':
                        answer[14]++;
                        break;

                    case '\u00E3':
                        answer[15]++;
                        break;

                    case '\u00F5':
                        answer[16]++;
                        break;

                    case '\u00E2':
                        answer[17]++;
                        break;

                    case '\u00EA':
                        answer[18]++;
                        break;

                    case '\u00EE':
                        answer[19]++;
                        break;

                    case '\u00F4':
                        answer[20]++;
                        break;

                    case '\u00FB':
                        answer[21]++;
                        break;
                }
        }

        answer[23] = getTag(html, "<br>"); // tag <br> counter
        answer[24] = getTag(html, "<table>"); // tag <table> counter

        // if the line break tag exists in the html, disregard the equivalent quantity
        // of the consonants 'b' and 'r' in the consoant counter
        if (answer[23] > 0) {
            answer[22] -= (2 * answer[23]);
        }

        // if the table tag exists in the html, disregard the equivalent quantity of the
        // consonants 't', 'b' and 'l' in the consoant counter and the equivalent
        // quantity of 'a' and 'e' in ther respective counters
        if (answer[24] > 0) {
            answer[0] -= answer[24];
            answer[1] -= answer[24];
            answer[22] -= (3 * answer[24]);
        }

        // finaly, prints each counter and the linked webpage
        MyIO.println("a(" + answer[0] + ") e(" + answer[1] + ") i(" + answer[2] + ") o(" + answer[3] + ") u("
                + answer[4] + ") " + printChar("\u00E1") + "(" + answer[5] + ") " + printChar("\u00E9") + "("
                + answer[6] + ") " + printChar("\u00ED") + "(" + answer[7] + ") " + printChar("\u00F3") + "("
                + answer[8] + ") " + printChar("\u00FA") + "(" + answer[9] + ") " + printChar("\u00E0") + "("
                + answer[10] + ") " + printChar("\u00E8") + "(" + answer[11] + ") " + printChar("\u00EC") + "("
                + answer[12] + ") " + printChar("\u00F2") + "(" + answer[13] + ") " + printChar("\u00F9") + "("
                + answer[14] + ") " + printChar("\u00E3") + "(" + answer[15] + ") " + printChar("\u00F5") + "("
                + answer[16] + ") " + printChar("\u00E2") + "(" + answer[17] + ") " + printChar("\u00EA") + "("
                + answer[18] + ") " + printChar("\u00EE") + "(" + answer[19] + ") " + printChar("\u00F4") + "("
                + answer[20] + ") " + printChar("\u00FB") + "(" + answer[21] + ") consoante(" + answer[22] + ") <br>("
                + answer[23] + ") <table>(" + answer[24] + ") " + webpage);
    }

    // If the input reads the word 'FIM', stop reading and skip the algorithm to the
    // next part
    private static boolean isEnd(String in) {
        return in.length() == 3 && in.charAt(0) == 'F' && in.charAt(1) == 'I' && in.charAt(2) == 'M';
    }

}