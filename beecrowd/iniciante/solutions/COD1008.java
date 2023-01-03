/* 
 * → This algorithm was created by Raick Miranda (Juunaz-for-real) on january 3rd, 2023.
 * → Copyright (c) 2022 Raick Miranda - MIT License.
 * 
 * → Fun fact: while coding I was listening to the song "Miss Americana" by Taylor Swift. ◠.◠
 */

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class COD1008 {

    public static void main(String[] args) throws Exception {
        DecimalFormat deci = new DecimalFormat("0.00");
        deci.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        int numbEmployer = MyIO.readInt(), workedHours = MyIO.readInt();
        double salaryPerHour = MyIO.readDouble();

        double salary = workedHours * salaryPerHour;

        System.out.println("NUMBER = " + numbEmployer);
        System.out.println("SALARY = U$ " + deci.format(salary));
    }

}