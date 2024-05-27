package biscuitfactory;

public class Main {
    public static void main(String[] args) {
        // Setting size in centimeters
        BiscuitProduction.setBiscuitSize(5);
        System.out.println("Current biscuit size being produced: " + BiscuitProduction.getBiscuitSize());

        // Setting amount of biscuits produced per minute
        BiscuitProduction.setProductionSpeed(1200);
        System.out.println("Current biscuits produced per minute: " + BiscuitProduction.getProductionSpeed());

        // Setting amount of chocolate chips per biscuit
        BiscuitProduction.setChocolatechipAmount(10);
        System.out.println("Current chocolate chips per biscuit: " + BiscuitProduction.getChocolatechipAmount());
    }
}