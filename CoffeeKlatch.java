package coffeeklatch;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.HashSet;

/**
 * Stimulates a coffee shop experience
 *
 * @author jenniferli (ICS4U)
 */
public class CoffeeKlatch {

    public static void main(String[] args) {

        displayMenu();
        String input = "";
        //takes in the user action, makes sure it's one of the options provided
        input = errorChecking(1);

        //create a new coffeeMachine
        CoffeeMachine makeCoffee = new CoffeeMachine();
        //create a new coffee cup
        CoffeeCup pouredCoffee = new CoffeeCup();
        boolean play = true;
        while (play) {
            switch (input) {
                //new customer
                case "n":
                    //refresh/renew the coffee machine
                    makeCoffee.Coffeemachine();
                    //ask for the customer name
                    pouredCoffee.CoffeeCup();
                    //ask for the size
                    System.out.printf("What size would you like? (s)mall, (m)edium, (l)arge: ");
                    pouredCoffee.setSize(errorChecking(2));
                    //ask for the strength
                    System.out.printf("How do you like your coffee? (w)eak, (r)egular, (s)trong, (k)iller intense: ");
                    makeCoffee.setStrength(errorChecking(3));
                    //display the new information, show the possible next acitons again
                    displayMenu();
                    //get the new action
                    input = errorChecking(1);
                    break;
                case "w"://add water
                    //add water
                    makeCoffee.addWater();
                    //display the new information, show the possible next acitons again
                    displayMenu();
                    //get the new action
                    input = errorChecking(1);
                    break;
                case "b"://add beans
                    makeCoffee.addBeans();
                    displayMenu();
                    input = errorChecking(1);
                    break;
                case "g"://grind the beans
                    makeCoffee.grindBeans();
                    displayMenu();
                    input = errorChecking(1);
                    break;
                case "r"://brew the coffee
                    makeCoffee.brew(pouredCoffee);
                    displayMenu();
                    input = errorChecking(1);
                    break;
                case "p"://pour the coffee into the cup
                    pouredCoffee.fill(makeCoffee);
                    displayMenu();
                    input = errorChecking(1);
                    break;
                case "d"://drink from the cup
                    pouredCoffee.drink();
                    displayMenu();
                    input = errorChecking(1);
                    break;
                case "x"://exit the game
                    play = false;
                    break;

            }
        }
    }

    /**
     * displays the current status of the coffee being made and the available
     * options for action
     */
    public static void displayMenu() {
        //displays the status of the coffee variables
        System.out.printf(CoffeeMachine.getStatus());
        //displays the possible actions
        System.out.printf(displayOptions());
    }

    /**
     * Possible actions
     *
     * @return List of possible actions (i.e. new customer, brew coffee etc.)
     */
    public static String displayOptions() {
        //display the possible action decisions
        String options = "Option: n - new customer\n\tw - add water\n\tb - Add Coffee Beans"
                + "\n\tg - Grind Beans\n\tr - Brew Coffee\n\tp - Pour a cup\n\td - drink a cup\n\tx - Exit"
                + "\n\t\tYour Choice?\n";

        return options;
    }

    /**
     * Makes sure the input is one of the options listed.
     * If it was an empty input or not one of the options provided, 
     * asks the user for input again
     * @param expectation, which hashSet is being checked (is it for an action,
     * setting the size of the coffee or strength?) 
     * @return if there were no errors found, returns user input. 
     */
    public static String errorChecking(int expectation) {
        //action hashSet
        HashSet<String> optionsList = new HashSet<String>();
        optionsList.add("n");
        optionsList.add("w");
        optionsList.add("b");
        optionsList.add("g");
        optionsList.add("r");
        optionsList.add("p");
        optionsList.add("d");
        optionsList.add("x");
        //size of the cup hashSet
        HashSet<String> sizeList = new HashSet<String>();
        sizeList.add("s");
        sizeList.add("m");
        sizeList.add("l");
        //strength of the coffee hashSet
        HashSet<String> strengthList = new HashSet<String>();
        strengthList.add("w");
        strengthList.add("r");
        strengthList.add("k");
        strengthList.add("s");

        Scanner keyboard = new Scanner(System.in);
        String input = "";

        //takes in the user's decision
        input = keyboard.nextLine();
        //based on what the program is asking for, checks to see if the user's input met the conditions
        switch (expectation) {
            case 1:
                //checks to make sure the input is one of the options
                while (!optionsList.contains(input)) {
                    //checks to make sure the user inputted something
                    while (input.isEmpty()) {

                        System.out.println("Please input an option. Don't leave the space blank");
                        input = keyboard.nextLine();
                    }
                    System.out.println("that's not one of the options. Try again: ");
                    input = keyboard.nextLine();
                }
                break;
            case 2:
                //checks to make sure the input is one of the options
                while (!sizeList.contains(input)) {
                    //checks to make sure the user inputted something
                    while (input.isEmpty()) {

                        System.out.println("Please input an option. Don't leave the space blank");
                        input = keyboard.nextLine();
                    }
                    System.out.println("that's not one of the options. Try again: ");
                    input = keyboard.nextLine();
                }
                break;
            case 3:
                //checks to make sure the input is one of the options
                while (!strengthList.contains(input)) {
                    //checks to make sure the user inputted something
                    while (input.isEmpty()) {

                        System.out.println("Please input an option. Don't leave the space blank");
                        input = keyboard.nextLine();
                    }
                    System.out.println("that's not one of the options. Try again: ");
                    input = keyboard.nextLine();
                }
                break;
        }
        //returns the user's decision
        return input;
    }

}
