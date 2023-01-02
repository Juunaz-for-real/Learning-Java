/* 
 * → This algorithm was created by Raick Miranda (Juunaz-for-real) on january 2nd, 2023.
 * → Copyright (c) 2022 Raick Miranda - MIT License.
 * 
 * → Fun fact: I love to watch TV series. ◠.◠
 */

public class COD1020 {

    public static void main(String[] args) throws Exception {
        int input = MyIO.readInt(), days = 0, months = 0, years = 0;

        if (input <= 30) {
            days += input;
        } else if (input > 30 && input <= 365) {
            days += (input % 30);
            months += (input / 30);
        } else {
            years += (input / 365);
            months += (input % 365) / 30;
            days += (input % 365) % 30;
        }

        System.out.println(years + " ano(s)");
        System.out.println(months + " mes(es)");
        System.out.println(days + " dia(s)");
    }

}