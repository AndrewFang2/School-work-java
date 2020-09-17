import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class contains the dynamically allocated array and it's processing
 * Student Name:Andrew Fang
 * Student Number:040974861
 * Course: CST8130 - Data Structures     :  CET-CS-Level 3
 * @author/Professor James Mwangi PhD.
 * @author Linda Crane
 * @author Melissa Sienkiewicz
 * @author Andrew Fang
 */

public class Number {
    /**
     * Stores Float values.
     */
    private Float [] numbers;
    /**
     * Store the number of items currently in the array.
     */
    private int numItems;
    //Max size
    private int size;
    /**
     * Default Constructor
     */
    public Number() {
        this.size = -1;
        this.numItems = 0;
        this.numbers = new Float[numItems];
    }

    /**
     * Constructor that initializes the numbers array.
     * @param size - Max size of the numbers array
     */
    public Number(int size) {
        this.numItems = 0;
        this.size = size;
        this.numbers = new Float[size];
    }

    /**
     * Adds a value in the array
     * @param keyboard - Scanner object to use for input
     */
    public void addValue(Scanner keyboard) {
        keyboard = new Scanner(System.in);
        float userInput = 0;
        System.out.print("Enter value: ");
        try {
            userInput = keyboard.nextFloat();
        }catch(InputMismatchException e) {
            System.out.println("That's not the float!");
            return;
        }
        //check
        if(size < 0) {
            Float[] arr = new Float[numItems+1];
            for(int i = 0; i < numItems; i++){
                arr[i] = numbers[i];
            }
            arr[numItems++] = userInput;
            numbers = arr;
        } else {
            try {
                numbers[numItems++] = userInput;
            }catch(IndexOutOfBoundsException e) {
                System.out.println("full");
                numItems--;
            }catch(Exception e) {
            }
        }
        return;
    }


    /**
     * Calculates the average of all the values in the numbers array.
     * @return float value that represents the average
     */
    public float calcAverage() {
        float sum = 0;
        for(int i = 0; i < numItems; i++) {
            sum += numbers[i];
        }
        return sum / numItems;
    }
    /**
     * Display the average
     */
    public void displayAvg() {
        try {
            if(numItems == 0) {
                System.out.print("Average is: " + 0.0f);
            }
            else {
                System.out.println("Average is: " + calcAverage());
            }

        }catch(ArithmeticException e) {
            System.out.print("");
        }
    }
    /**
     * Adds a value in the array
     * @return String
     */
    @Override
    public String toString() {
        System.out.println("Numbers are: ");
        String str = "";
        for(int i = 0; i < numItems; i++) {
            str += numbers[i] + "\n";
        }
        return str;
    }
    public void print(PrintWriter printWriter) {
        System.out.println(this.toString());
        printWriter.print(toString());
    }

    public void read(Scanner keyboard){
        float userInput = 0;
        userInput = keyboard.nextFloat();
        if(size < 0) {
            Float[] arr = new Float[numItems+1];
            for(int i = 0; i < numItems; i++){
                arr[i] = numbers[i];
            }
            arr[numItems++] = userInput;
            numbers = arr;
        } else {
            try {
                numbers[numItems++] = userInput;
            }catch(IndexOutOfBoundsException e) {
                System.out.println("full");
                numItems--;
            }catch(Exception e) {
            }
        }
    }
}


