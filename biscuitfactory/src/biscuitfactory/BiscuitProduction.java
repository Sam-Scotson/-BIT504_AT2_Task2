package biscuitfactory;

public class BiscuitProduction {
    private static BiscuitProduction instance = null;
    private static int biscuitSize;
    private static int productionSpeed;

    // Private constructor to prevent instantiation
    private BiscuitProduction() {
    }

    // Method to get the single instance of BiscuitProduction
    public static BiscuitProduction getInstance() {
        if (instance == null) {
            instance = new BiscuitProduction();
        }
        return instance;
    }

    // Getter and setter for biscuitSize
    public static int getBiscuitSize() {
        return biscuitSize;
    }

    public static void setBiscuitSize(int biscuitSize) {
        BiscuitProduction.biscuitSize = biscuitSize;
    }

    // Getter and setter for productionSpeed
    public static int getProductionSpeed() {
        return productionSpeed;
    }

    public static void setProductionSpeed(int productionSpeed) {
        BiscuitProduction.productionSpeed = productionSpeed;
    }
}
