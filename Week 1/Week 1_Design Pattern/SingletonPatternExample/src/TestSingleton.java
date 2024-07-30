
public class TestSingleton {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Log messages
        logger1.log("First message");
        logger2.log("Second message");

        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("Different instances of Logger were created.");
        }
    }
}
