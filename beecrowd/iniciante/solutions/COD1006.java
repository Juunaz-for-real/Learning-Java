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

public class COD1006 {

    public static void main(String[] args) throws Exception {
        DecimalFormat deci = new DecimalFormat("0.0");
        deci.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        double grades[] = new double[3];

        for (int index = 0; index < grades.length; index++) {
            grades[index] = MyIO.readDouble();
        }

        int weight[] = new int[] { 2, 3, 5 };
        int sum = 0;

        for (int counter = 0; counter < weight.length; counter++) {
            sum += weight[counter];
        }

        double calc = ((grades[0] * weight[0]) + (grades[1] * weight[1]) + (grades[2] * weight[2])) / sum;

        System.out.println("MEDIA = " + deci.format(calc));

    }

}