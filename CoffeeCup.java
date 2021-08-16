package coffeeklatch;

import java.util.Scanner;

public class CoffeeCup {

    Scanner keyboard = new Scanner(System.in);
    private static String name;//customer name
    public static String cupSize;//SMALL, MEDIUM or LARGE
    private int waterUsage;//how much water does the cup size use each time
    private static boolean isFull;  // Is this cup full?  Default value false.

    /**
     * default function, asks the user for the name, 
     * making sure the name has no symbols or isn't empty
     */
    public void CoffeeCup() {
        System.out.println("Resetting flags");
        //asks for customer name
        System.out.print("What is your name?: ");
        //takes in the input
        String input = keyboard.nextLine();
        boolean noSymbols = false;//does the input contain symbols?
        
        //checks through each character in the input, making sure there's no symbols/numbers
        while (!noSymbols) {
            //go through each character
            for (int i = 0; i < input.length(); i++) {
                if (Character.isLetter(input.charAt(i))) {
                    noSymbols = true;
                } else {//if it isn't a letter ask for the name again
                    noSymbols = false;
                    i = input.length();
                    System.out.println("Please only enter letters");
                    input = keyboard.nextLine();
                }
            }
            //makes sure the string isn't empty
            while (input.isEmpty()) {
                System.out.println("Please input a name. Don't leave the space blank");
                input = keyboard.nextLine();
            }

        }
        //set the name of the customer to the given input
        setName(input);
    }

    /**
     * Sets the corresponding title and waterUsage levels according to the size
     * of the cup
     *
     * @param cupSize
     */
    public void setSize(String cupSize) {
        switch (cupSize) {
            case "s":
                this.cupSize = "SMALL";
                waterUsage = 2;
                break;
            case "m":
                this.cupSize = "MEDIUM";
                waterUsage = 3;
                break;
            case "l":
                this.cupSize = "LARGE";
                waterUsage = 4;
                break;

        }
    }

    /**
     * Returns the title of the size of the cup
     *
     * @return SMALL, MEDIUM or LARGE, depending on what the user chose
     */
    public static String getCupsize() {
        return cupSize;
    }

    /**
     * Sets the users name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the users name
     *
     * @return name
     */
    public static String getName() {
        return name;
    }

    /**
     * Returns whether this cup is full (true) or empty(false);
     *
     * @return is this cup full?
     */
    public static boolean isFull() {
        return isFull;
    }

    /**
     * Fills this cup to the top, checks if the coffee is brewed first, checks
     * if the coffee cup is already full, checks if the pot has enough coffee
     * left for another cup before pouring
     */
    public void fill(CoffeeMachine test) {
        //makes sure the a pot of coffee is brewed before the user can pour a cup
        if (CoffeeMachine.getCoffeeBrewedStatus() == false) {
            System.out.println("==You must brew a pot of Coffee first!");
        } else {
            //makes sure the cup isn't already full
            if (isFull == true) {
                System.out.println("==Your cup is already full!");
            } 
            //makes sure there's enough coffee in the pot left to pour another cup
            else if ((CoffeeMachine.getWaterLevel() - waterUsage) < 0) {
                System.out.println("==You need to make more coffee!");
            } 
            //pours a cup of coffee
            else {
                isFull = true;
                test.setWaterLevel(waterUsage);
                System.out.println("==You poured a cup of coffee");
            }
        }

    }

    /**
     * Drink this cup entirely
     */
    public boolean drink() {
        //if the coffee hasn't already been consumed, drink the whole cup
        if (isFull) {
            System.out.println("==" + name + " glugs the coffee down.");
            System.out.println("==Yum!");
            isFull = false;
            return true;
        } 
        //if the coffee has already been consumed, let the user know
        else {
            System.out.println("==" + name + " sips furiously, but only suck air.");
            return false;
        }

    }
}
