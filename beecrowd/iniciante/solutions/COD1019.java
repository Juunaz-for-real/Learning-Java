/* 
 * → This algorithm was created by Raick Miranda (Juunaz-for-real) on january 2nd, 2023.
 * → Copyright (c) 2022 Raick Miranda - MIT License.
 * 
 * → Fun fact: next month I will turn 22 years old. ◠.◠
 */

public class COD1019 {

    public static void main(String[] args) throws Exception {
        int input = MyIO.readInt(), seconds = 0, minutes = 0, hours = 0;

        if (input <= 59) {
            seconds += input;
        } else if (input > 59 && input <= 3599) {
            seconds += (input % 60);
            minutes += (input / 60);
        } else {
            hours += (input / 3600);
            minutes += (input % 3600) / 60;
            seconds += (input % 3600) % 60;
        }

        System.out.println(hours + ":" + minutes + ":" + seconds);
    }

}