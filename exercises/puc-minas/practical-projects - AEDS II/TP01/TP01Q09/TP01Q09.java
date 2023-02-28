/*
 * Author: Raick Miranda Rodrigues Santos
 * Registration Number: 781755
 * Objective: TP01Q09 - Practical project from the AEDS II course
 * 
 * \_(*-*)/¨ 
 */

// Imported Libraries
import java.io.IOException;
import java.io.RandomAccessFile;

public class TP01Q09 {

    // The main part of the algorithm
    public static void main(String[] args) throws IOException {
        int quantity = MyIO.readInt();
        RandomAccessFile raf = new RandomAccessFile("aux.txt", "rw");

        // writes to the file 'aux.txt' the doubles read on command line
        for (int index = 1; index <= quantity; index++) {
            double value = MyIO.readDouble();
            raf.writeDouble(value);
        }

        // return the offset from the beginning of the file, in bytes, at which the next
        // read or write occurs
        int position = (int) raf.getFilePointer();
        raf.close();

        // reopens the file 'aux.txt', so it can be read
        raf = new RandomAccessFile("aux.txt", "r");

        // scans using 8 as it is the size of a double
        for (int inByte = 8; inByte <= position; inByte += 8) {
            raf.seek(position - inByte);
            double aux = raf.readDouble();

            if (aux % 1 != 0)
                MyIO.println(aux);
            else // if it's an integer converts it
                MyIO.println((int) aux);
        }

        // closes the file
        raf.close();
    }

}