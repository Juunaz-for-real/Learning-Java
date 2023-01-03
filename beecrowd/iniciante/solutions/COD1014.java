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

public class COD1014 {

    public static void main(String[] args) throws Exception {
        DecimalFormat deci = new DecimalFormat("0.000");
        deci.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        int km = MyIO.readInt();
        double fuel = MyIO.readDouble();

        double averageFuel = km / fuel;

        System.out.println(deci.format(averageFuel) + " km/l");
    }

}