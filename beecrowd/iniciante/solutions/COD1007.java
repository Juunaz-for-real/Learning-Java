/* 
 * → This algorithm was created by Raick Miranda (Juunaz-for-real) on january 1st, 2023.
 * → Copyright (c) 2022 Raick Miranda - MIT License.
 * 
 * → Fun fact: while coding I was listening to BORN album "Dopamine" ◠.◠
 */

public class COD1007 {
    /* the purpose of this algorithm is to print the difference of the
     * product of the variables */
    public static void main(String[] args) throws Exception {
        int[] numbers = new int[4];

        for(int index = 0; index < numbers.length; index++){
            numbers[index] = MyIO.readInt();
        }

        int AB = numbers[0] * numbers[1];
        int CD = numbers[2] * numbers[3];

        int diferenca = AB - CD;

        MyIO.println("DIFERENCA = " + diferenca);
    }
}