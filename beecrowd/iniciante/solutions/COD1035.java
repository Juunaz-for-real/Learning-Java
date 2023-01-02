/* 
 * → This algorithm was created by Raick Miranda (Juunaz-for-real) on january 2nd, 2023.
 * → Copyright (c) 2022 Raick Miranda - MIT License.
 * 
 * → Fun fact: while coding I was listening to the song "Speechless" by Dan + Shay. ◠.◠
 */

public class COD1035 {

    public static void main(String[] args) throws Exception {
        int[] numbers = new int[4];

        for (int index = 0; index < numbers.length; index++) {
            numbers[index] = MyIO.readInt();
        }

        int sumCD = numbers[2] + numbers[3], sumAB = numbers[0] + numbers[1];

        if (numbers[1] > numbers[2] && numbers[3] > numbers[0] &&
                sumCD > sumAB && numbers[2] > 0 && numbers[3] > 0 &&
                (numbers[0] % 2) == 0) {
            MyIO.println("Valores aceitos");
        } else {
            MyIO.println("Valores nao aceitos");
        }
    }

}