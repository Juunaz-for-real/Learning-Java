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

public class COD1037 {

    public static void main(String[] args) throws Exception {
        DecimalFormat deci = new DecimalFormat("0.000");
        deci.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        double input = MyIO.readDouble();

        if(input > 0 && input <= 25){
            System.out.println("Intervalo [0,25]");
        } else if (input > 25 && input <= 50){
            System.out.println("Intervalo (25,50]");
        } else if(input > 50 && input <= 75){
            System.out.println("Intervalo (50,75]");
        } else if(input > 75 && input <= 100){
            System.out.println("Intervalo (75,100]");
        } else {
            System.out.println("Fora de intervalo");
        }
    }

}