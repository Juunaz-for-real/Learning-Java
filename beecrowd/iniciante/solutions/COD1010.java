/* 
 * → This algorithm was created by Raick Miranda (Juunaz-for-real) on january 2nd, 2023.
 * → Copyright (c) 2022 Raick Miranda - MIT License.
 * 
 * → Fun fact: while coding I was listening to the song "Someone else's problem" by Ruel. ◠.◠
 */

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class COD1010 {

    public static void main(String[] args) throws Exception {
        DecimalFormat deci = new DecimalFormat("0.00");
        deci.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        double[] input = new double[6];

        for(int index = 0; index < input.length; index++){
            input[index] = MyIO.readDouble();
        }

        double price = (input[1] * input[2]) + (input[4] * input[5]);

        System.out.println("VALOR A PAGAR: R$ " + deci.format(price));
    }

}