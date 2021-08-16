package coffeeklatch;

/**
 * creates a coffee machine with various coffee related variables (i.e water
 * level, beans etc.)
 *
 * @author jenniferli
 */
public class CoffeeMachine {

    private static int waterLevel;
    private static String strength;
    private static boolean waterStatus;
    private static boolean beansStatus;
    private static boolean beansGrindStatus;
    private static boolean coffeeBrewedStatus;

    /**
     * default values of the coffee machine
     */
    public void Coffeemachine() {
        waterLevel = 0;
        waterStatus = false;
        beansStatus = false;
        beansGrindStatus = false;
        coffeeBrewedStatus = false;
    }

    /**
     * puts together a status message of the current machine and customer
     * information
     *
     * @return displayed status of coffee machine + customer variables
     */
    public static String getStatus() {
        //build status message with current corresponding variables
        String status = "\t\t\t\t\t\t\t MACHINE\t\t\t USER: " + CoffeeCup.getName() + "\tCup Size: " + CoffeeCup.getCupsize()
                + "\n\t\t\t\t\tWater\tLevel\tBeans\tBeansGround\tCoffeeBrewed\tCup Full\tStrength\n"
                + "\t\t\t\t\t" + waterStatus + "\t" + waterLevel + "\t" + beansStatus + "\t" + beansGrindStatus + "\t\t" + coffeeBrewedStatus + "\t\t" + CoffeeCup.isFull() + "\t\t" + strength + "\n";

        return status;
    }

    /**
     * Set the strength of the Coffee to s; affects the fineness of the grind. 4
     * different coffee strengths
     *
     * @param srength, the customers desired coffee strength
     */
    public void setStrength(String srength) {
        switch (srength) {
            case "r":
                srength = "regular";
                break;
            case "w":
                srength = "weak";
                break;
            case "k":
                srength = "killer Intense";
                break;
            case "s":
                srength = "strong";
                break;
        }
        this.strength = srength;
    }

    /**
     * Adds beans to the coffee machine
     */
    public void addBeans() {
        //checks to see if the beans are already added
        if (beansStatus == true) {
            System.out.println("==The beans are already added");
        } //add the beans
        else {
            System.out.println("==Adding Beans");
            beansStatus = true;
        }

    }

    /**
     * Adds water to the coffee machine, max capacity of water tank is 10
     */
    public void addWater() {
        //if the water level is not at max capacity add water
        if (waterLevel != 10) {
            waterLevel = 10;
            waterStatus = true;
            System.out.println("==Adding Water");
        }
        System.out.println("==Your water level is now at maximum capacity");
    }

    /**
     * Checks to make sure beans are added and customer info is inputted Grinds
     * the beans, updates the status of grinded beans
     */
    public void grindBeans() {
        //makes sure the customer's desired bean strength is recorded
        if (CoffeeCup.getName() == null) {
            System.out.println("==Put down a customer first (enter 'n' for new customer)");
        } //makes sure theres beans in the capartment to grind
        else if (beansStatus == false) {
            System.out.println("==You must add some coffee beans first!");
        } //checks to see if the beans are already grinded
        else if (beansGrindStatus == true) {
            System.out.println("==The beans are already grinded");
        } //grind the beans
        else {
            System.out.println("==Grinding beans for "
                    + strength + " coffee.");
            beansGrindStatus = true;
        }
    }

    /**
     * Checks to make sure the water tank is full, and the beans are grinded,
     * brews a pot of coffee for a given cup
     *
     * @param cup, coffee cup
     */
    public void brew(CoffeeCup cup) {
        //makes sure there is water in the machine
        if (waterStatus == false) {
            System.out.println("==You need to add water first!");
        } //makes sure the beans are grinded
        else if (beansGrindStatus == false) {
            System.out.println("==You must grind some coffee beans first!");
        } //checks to see if theres already brewed cofee
        else if (coffeeBrewedStatus == true) {
            System.out.println("==The coffee is already brewed");
        } //brews the coffee
        else {
            System.out.println("==Brewing " + strength + " coffee for " + cup.getName());
            coffeeBrewedStatus = true;
            System.out.println("==your coffee is ready to be poured");
        }
    }

    /**
     * Decreases the water level everytime a cup of coffee is poured, when the
     * waterlevel is 0 sets the waterStatus to 0
     *
     * @param waterLevel, depends on the size of the cup
     */
    public void setWaterLevel(int waterLevel) {
        //decrease the waterLevel by the how much water is needed to pour a cup of that size
        this.waterLevel -= waterLevel;
        //if theres no more water, set the status to false
        if (this.waterLevel == 0) {
            waterStatus = false;
        }
    }

    /**
     * Gets the current waterLevel of the coffee pot
     *
     * @return waterLevel
     */
    public static int getWaterLevel() {
        return waterLevel;
    }

    /**
     * Returns the status of the brewed coffee
     *
     * @return true, if there is brewed coffee, false, if there isn't
     */
    public static boolean getCoffeeBrewedStatus() {
        return coffeeBrewedStatus;
    }
}
