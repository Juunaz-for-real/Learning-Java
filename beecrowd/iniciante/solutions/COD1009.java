/* 
 * → This algorithm was created by Raick Miranda (Juunaz-for-real) on january 3rd, 2023.
 * → Copyright (c) 2022 Raick Miranda - MIT License.
 * 
 * → Fun fact: while coding I was listening to the radio (Spotify Auto-Generated Playlist) 
 *   of the song "Mother's Daughter" by Miley Cyrus. ◠.◠
 */

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class COD1009 {

    public static void main(String[] args) throws Exception {
        DecimalFormat deci = new DecimalFormat("0.00");
        deci.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        String name = MyIO.readLine();
        double[] input = new double[2];

        for(int index = 0; index < input.length; index++){
            input[index] = MyIO.readDouble();
        }

        double salary = input[0] + (input[1] * 0.15);

        System.out.println("TOTAL = R$ " + deci.format(salary));
    }

}