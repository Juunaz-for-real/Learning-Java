/**
 * @author Raick Miranda Rodrigues Santos
 * @file TP02Q01.java
 * @date 2023-03-13
 * @objective TP02Q07
 * 
 *            Registration Number: 781755
 *            (⊙_⊙)？
 */

// Imported Libraries
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class TP02Q07 {

    // The main part of the algorithm
    public static void main(String[] args) throws Exception {
        String[] input = new String[30], secondInput = new String[30];
        int inCounter = 0;
        MyIO.setCharset("UTF-8");

        // read entries while isEnd is false (first part)
        do
            input[inCounter] = MyIO.readLine();
        while (!isEnd(input[inCounter++]));
        inCounter--; // disregard the line 'FIM'

        // adding the specified objects in the first input
        LinearList starWarsList = new LinearList(100);
        for (int index = 0; index < inCounter; index++) {
            Character starWars = new Character();
            starWars.read(input[index]);
            starWarsList.addAtLastPosition(starWars);
        }

        // read entries while isEnd is false (second part)
        inCounter = 0;
        do
            secondInput[inCounter] = MyIO.readLine();
        while (!isEnd(secondInput[inCounter++]));
        inCounter--;

        long time = System.nanoTime();
        for (int index = 0; index < inCounter; index++) {
            if (starWarsList.linearSearch(secondInput[index]))
                System.out.println("SIM");
            else
                System.out.println("NAO");
        }
        time = (System.nanoTime() - time);
        printLogFile("781755_sequencial.txt", Character.getNumComp(), time);
    }

    /**
     * Creates a text file that stores the performance information of the sequential
     * search
     * 
     * @param fileName - the name of the file to be created (registration number +
     *                 algorithm)
     * @param numComp  - number of comparisons made in linear search
     * @param time     - algorithm execution time (considering only the linear
     *                 search)
     * @throws Exception - may potentially throws an 'exception' during execution
     */
    public static void printLogFile(String fileName, long numComp, long time) throws Exception {
        PrintWriter pw = new PrintWriter(fileName, "UTF-8");
        pw.println("781755\t" + numComp + "\t" + time + "ns\t");
        pw.close();
    }

    /**
     * If the input reads the word 'FIM', stop reading and skip the algorithm to the
     * next part
     * 
     * @param in - input line that receives pub.in
     * @return - returns true to stop reading data
     */
    private static boolean isEnd(String in) {
        return in.length() == 3 && in.charAt(0) == 'F' && in.charAt(1) == 'I' && in.charAt(2) == 'M';
    }
}

// Linear List class
class LinearList extends Character {

    // Declaration of attributes
    Character[] starWarsArray;
    private static int linearListLength;

    // Constructors
    LinearList() {
        this(5);
    }

    LinearList(int length) {
        starWarsArray = new Character[length];
        linearListLength = 0;
    }

    public static int getLinearListLength() {
        return linearListLength;
    }

    /**
     * Adds the object in the first position of the array. The other occupants of
     * the array are shifted to the right and the element passed by parameter will
     * occupy the first position, if there is enough room for insertion
     * 
     * @param in - object of type character that will be inserted in the list
     * @throws Exception - may potentially throws an 'exception' during execution
     *                   due to the size of the list
     */
    void addAtFirstPosition(Character in) throws Exception {
        if (linearListLength >= starWarsArray.length)
            throw new Exception("Error adding character, list is full!");

        for (int index = linearListLength; index > 0; index--)
            starWarsArray[index] = starWarsArray[index - 1].cloneCharacter();

        starWarsArray[0] = in.cloneCharacter();
        linearListLength++;
    }

    /**
     * Adds an object at the last empty position in the array, if there is enough
     * room for insertion
     * 
     * @param in - object of type character that will be inserted in the list
     * @throws Exception - may potentially throws an 'exception' during execution
     *                   due to the size of the list
     */
    void addAtLastPosition(Character in) throws Exception {
        if (linearListLength >= starWarsArray.length)
            throw new Exception("Error adding character, list is full!");

        starWarsArray[linearListLength] = in.cloneCharacter();
        linearListLength++;
    }

    /**
     * Adds the object at the specified position. Objects that are in a position
     * greater than or equal to the indicated position will be moved to the
     * right and the object will be integrated in the desired position. The other
     * objects remain untouched. Insertion only takes place if there is enough
     * room and if the specified index is valid
     * 
     * @param in  - object of type character that will be inserted in the list
     * @param pos - int containing the index where the object should be added
     * @throws Exception - may potentially throws an 'exception' during execution
     *                   due to the size of the list
     */
    void addAtPosition(Character in, int pos) throws Exception {
        if (linearListLength >= starWarsArray.length || pos < 0 || pos > linearListLength)
            throw new Exception("Error adding character, list is full!");

        for (int index = linearListLength; index > pos; index--)
            starWarsArray[index] = starWarsArray[index - 1].cloneCharacter();

        starWarsArray[pos] = in.cloneCharacter();
        linearListLength++;
    }

    /**
     * If the array is not empty, it removes the object from the first position,
     * while the other occupants of the array are moved to the left
     * 
     * @return - the object that was removed
     * @throws Exception - may potentially throws an 'exception' during execution
     *                   due to the size of the list
     */
    Character removeFromFirstPosition() throws Exception {
        if (linearListLength == 0)
            throw new Exception("Removal error, list is empty!");

        Character toBeRemoved = starWarsArray[0].cloneCharacter();
        linearListLength--;

        for (int index = 0; index < linearListLength; index++)
            starWarsArray[index] = starWarsArray[index + 1].cloneCharacter();

        return toBeRemoved;
    }

    /**
     * If the array is not empty, it removes the object that occupies the last
     * position
     * 
     * @return - the object that was removed
     * @throws Exception - may potentially throws an 'exception' during execution
     *                   due to the size of the list
     */
    Character removeFromLastPosition() throws Exception {
        if (linearListLength == 0)
            throw new Exception("Removal error, list is empty!");

        return starWarsArray[--linearListLength].cloneCharacter();
    }

    /**
     * If the list is not empty, removes the object at the specified position and
     * moves the other objects to the left
     * 
     * @param pos - the object to be removed
     * @return - the object that was removed
     * @throws Exception - may potentially throws an 'exception' during execution
     *                   due to the size of the list
     */
    Character removeFromPosition(int pos) throws Exception {
        if (linearListLength == 0 || pos < 0 || pos > linearListLength)
            throw new Exception("Removal error, list is empty!");

        Character toBeRemoved = starWarsArray[pos].cloneCharacter();
        linearListLength--;

        for (int index = pos; index < linearListLength; index++)
            starWarsArray[index] = starWarsArray[index + 1].cloneCharacter();

        return toBeRemoved;
    }

    /**
     * Performs a sequential list search using the key "name" for objects of type
     * character.
     * 
     * @param in - name of the character that will be searched
     * @return - a boolean value that indicates whether the searched object is in
     *         the list or not
     */
    boolean linearSearch(String in) {
        boolean answer = false;

        for (int index = 0; index < linearListLength; index++) {
            Character.numComp++;

            if (starWarsArray[index].getName().compareTo(in) == 0) {
                answer = true;
                break;
            }
        }

        return answer;
    }

    /**
     * Prints the list of objects of type character
     */
    void printLinearList() {
        Character aux = new Character();

        for (int index = 0; index < linearListLength; index++) {
            aux = starWarsArray[index];
            System.out.print("[" + index + "] ");
            aux.print();
        }
    }

}

// Character class
class Character {

    // Declaration of attributes
    private String name, dateOfBirth, gender, homeworld;
    private ArrayList<String> hairColor, skinColor, eyesColor;
    private int height;
    private double mass;
    protected static long numComp = 0, numMov = 0;

    // Constructors
    public Character() {
        this.name = this.dateOfBirth = this.gender = this.homeworld = null;
        this.hairColor = new ArrayList<String>();
        this.skinColor = new ArrayList<String>();
        this.eyesColor = new ArrayList<String>();
        this.height = -1;
        this.mass = -1;
    }

    public Character(String name, int height, double mass, ArrayList<String> hairColor, ArrayList<String> skinColor,
            ArrayList<String> eyesColor, String dateOfBirth, String gender, String homeworld) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.eyesColor = eyesColor;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.homeworld = homeworld;
    }

    /**
     * Clones an object
     * 
     * @return - returns a cloned object
     */
    public Character cloneCharacter() {
        Character clone = new Character();

        clone.name = this.name;
        clone.height = this.height;
        clone.mass = this.mass;
        clone.hairColor = this.hairColor;
        clone.skinColor = this.skinColor;
        clone.eyesColor = this.eyesColor;
        clone.dateOfBirth = this.dateOfBirth;
        clone.gender = this.gender;
        clone.homeworld = this.homeworld;

        return clone;
    }

    // Getters through encapsulation
    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public double getmass() {
        return mass;
    }

    public ArrayList<String> getHairColor() {
        return hairColor;
    }

    public ArrayList<String> getSkinColor() {
        return skinColor;
    }

    public ArrayList<String> getEyesColor() {
        return eyesColor;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getgender() {
        return gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public static long getNumComp() {
        return numComp;
    }

    public long getNumMov() {
        return numMov;
    }

    // Setters through encapsulation
    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setmass(double mass) {
        this.mass = mass;
    }

    public void setHairColor(ArrayList<String> hairColor) {
        this.hairColor = hairColor;
    }

    public void setSkinColor(ArrayList<String> skinColor) {
        this.skinColor = skinColor;
    }

    public void setEyesColor(ArrayList<String> eyesColor) {
        this.eyesColor = eyesColor;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setgender(String gender) {
        this.gender = gender;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    /**
     * Prints each attribute of an object of the character class
     */
    public void print() {
        String hair = Arrays.toString(this.hairColor.toArray()).replace("[", "").replace("]", "");
        String skin = Arrays.toString(this.skinColor.toArray()).replace("[", "").replace("]", "");
        String eyes = Arrays.toString(this.eyesColor.toArray()).replace("[", "").replace("]", "");
        String aux = Double.toString(this.mass), cut = "";

        System.out.print(" ## " + this.name + " ## " + this.height + " ## ");

        // treating decimals for double
        for (int index = 0, i = 0; index < aux.length(); index++) {
            if (aux.charAt(index) == '.' && aux.charAt(index + 1) == '0') {
                while (i <= aux.length() - 3) {
                    cut += aux.charAt(i);
                    i++;
                }
                System.out.print(cut);
                break;
            } else if (aux.charAt(index) == '.'
                    && (isNumber(aux.charAt(index + 1)) && aux.charAt(index + 1) != 0)) {
                System.out.print(aux);
            }
        }

        System.out.println(" ## " + hair + " ## " + skin + " ## " + eyes + " ## " + this.dateOfBirth + " ## "
                + this.gender + " ## " + this.homeworld + " ## ");
    }

    /**
     * Reads a text file and then assigns the identified values to the attributes of
     * the Character class
     * 
     * @param file - the document to be read
     * @throws IOException - IO error handling
     */
    public void read(String file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));

        String line, aux = "", tempString = "";

        // store the file contents to a string
        while ((line = br.readLine()) != null) {
            aux = line;
        }
        br.close();

        int index = 0, auxQuoteMark = 0;

        // find - character name -
        while (true) {
            index++;

            if (aux.charAt(index) == '\'')
                auxQuoteMark++;

            if (auxQuoteMark == 3) {
                index++;

                while (aux.charAt(index) != '\'') {
                    tempString += aux.charAt(index);
                    index++;
                }
                this.name = tempString;
                index += 2;
                break;
            }
        }
        auxQuoteMark = 0;
        tempString = "";

        // find - character heigth -
        while (true) {
            index++;

            if (aux.charAt(index) == '\'')
                auxQuoteMark++;

            if (auxQuoteMark == 3) {
                index++;

                // if the height is unknown, set 0
                if (aux.charAt(index) == 'u') {
                    this.height = 0;

                    while (aux.charAt(index) != '\'')
                        index++;

                    index += 2;
                    break;
                } else {
                    while (aux.charAt(index) != '\'' && isNumber(aux.charAt(index))) {
                        tempString += aux.charAt(index);
                        index++;
                    }
                    this.height = Integer.parseInt(tempString);
                    index += 2;
                    break;
                }
            }
        }
        auxQuoteMark = 0;
        tempString = "";

        // find - character mass -
        while (true) {
            index++;

            if (aux.charAt(index) == '\'')
                auxQuoteMark++;

            if (auxQuoteMark == 3) {
                index++;

                // if the mass is unknown, set 0
                if (aux.charAt(index) == 'u') {
                    this.mass = 0;

                    while (aux.charAt(index) != '\'')
                        index++;

                    index += 2;
                    break;
                } else {
                    while (aux.charAt(index) != '\''
                            && (isNumber(aux.charAt(index)) || aux.charAt(index) == '.'
                                    || aux.charAt(index) == ',')) {

                        // if it's a comma, replace it with a blank space
                        if (aux.charAt(index) == ',') {
                            tempString += "";
                            index++;
                        }

                        tempString += aux.charAt(index);
                        index++;
                    }
                    this.mass = Double.parseDouble(tempString);
                    index += 2;
                    break;
                }
            }
        }
        auxQuoteMark = 0;
        tempString = "";

        // find - character hair color -
        while (true) {
            index++;

            if (aux.charAt(index) == '\'')
                auxQuoteMark++;

            if (auxQuoteMark == 4) {
                index += 2;
                break;
            }

            if (auxQuoteMark == 3) {
                index++;

                while (aux.charAt(index) != '\'') {
                    if (aux.charAt(index) == ',') {
                        index++;
                        break;
                    }
                    tempString += aux.charAt(index);
                    index++;
                }
                index--; // decrementing by 1 to ensure that it doesn't loop infinitely
                this.hairColor.add(tempString);
                tempString = "";
            }
        }
        auxQuoteMark = 0;

        // find - character skin color -
        while (true) {
            index++;

            if (aux.charAt(index) == '\'')
                auxQuoteMark++;

            if (auxQuoteMark == 4) {
                index += 2;
                break;
            }

            if (auxQuoteMark == 3) {
                index++;

                while (aux.charAt(index) != '\'') {
                    if (aux.charAt(index) == ',') {
                        index++;
                        break;
                    }
                    tempString += aux.charAt(index);
                    index++;
                }
                index--; // decrementing by 1 to ensure that it doesn't loop infinitely
                this.skinColor.add(tempString);
                tempString = "";
            }
        }
        auxQuoteMark = 0;

        // find - character eyes color -
        while (true) {
            index++;

            if (aux.charAt(index) == '\'')
                auxQuoteMark++;

            if (auxQuoteMark == 4) {
                index += 2;
                break;
            }

            if (auxQuoteMark == 3) {
                index++;

                while (aux.charAt(index) != '\'') {
                    if (aux.charAt(index) == ',') {
                        index++;
                        break;
                    }
                    tempString += aux.charAt(index);
                    index++;
                }
                index--; // decrementing by 1 to ensure that it doesn't loop infinitely
                this.eyesColor.add(tempString);
                tempString = "";
            }
        }
        auxQuoteMark = 0;

        // find - character date of birth -
        while (true) {
            index++;

            if (aux.charAt(index) == '\'')
                auxQuoteMark++;

            if (auxQuoteMark == 3) {
                index++;

                while (aux.charAt(index) != '\'') {
                    tempString += aux.charAt(index);
                    index++;
                }
                this.dateOfBirth = tempString;
                index += 2;
                break;
            }
        }
        auxQuoteMark = 0;
        tempString = "";

        // find - character gender -
        while (true) {
            index++;

            if (aux.charAt(index) == '\'')
                auxQuoteMark++;

            if (auxQuoteMark == 3) {
                index++;

                while (aux.charAt(index) != '\'') {
                    tempString += aux.charAt(index);
                    index++;
                }
                this.gender = tempString;
                index += 2;
                break;
            }
        }
        auxQuoteMark = 0;
        tempString = "";

        // find - character homeworld -
        while (true) {
            index++;

            if (aux.charAt(index) == '\'')
                auxQuoteMark++;

            if (auxQuoteMark == 3) {
                index++;

                while (aux.charAt(index) != '\'') {
                    tempString += aux.charAt(index);
                    index++;
                }
                this.homeworld = tempString;
                index += 2;
                break;
            }
        }
        auxQuoteMark = 0;
        tempString = "";

    }

    /**
     * Takes a character and says whether it is a number or not
     * 
     * @param in - character
     * @return - boolean value 'true' if it is a number
     */
    private static boolean isNumber(char in) {
        return in >= 48 && in <= 57;
    }

}