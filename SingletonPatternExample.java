// SingletonPatternExample.java - Main Class
public class SingletonPatternExample {
    public static void main(String[] args) {
        System.out.println("=== Singleton Pattern Implementation Demo ===\n");

        testSingletonImplementation();

        demonstrateLoggingFunctionality();
    }

    public static void testSingletonImplementation() {
        System.out.println("Testing Singleton Implementation:");
        System.out.println("-".repeat(40));

        Logger logger1 = Logger.getInstance();
        System.out.println("First Logger instance obtained");
        logger1.displayLoggerInfo();

        Logger logger2 = Logger.getInstance();
        System.out.println("\nSecond Logger instance obtained");
        logger2.displayLoggerInfo();

        System.out.println("\nSingleton Verification:");
        System.out.println("Are both instances the same object? " + (logger1 == logger2));
        System.out.println("Hash codes match? " + (logger1.hashCode() == logger2.hashCode()));
        System.out.println("References equal? " + logger1.equals(logger2));
        
        System.out.println("\n" + "=".repeat(50) + "\n");
    }

    public static void demonstrateLoggingFunctionality() {
        System.out.println("Demonstrating Logging Functionality:");
        System.out.println("-".repeat(40));

        Logger logger = Logger.getInstance();

        logger.logInfo("Application started successfully");
        logger.logInfo("User authentication completed");
        logger.logWarning("Memory usage is approaching 80%");
        logger.logError("Failed to connect to database");
        logger.logInfo("Retrying database connection...");
        logger.logInfo("Database connection established");
        logger.logInfo("Application running normally");
        
        System.out.println("\nLogging demonstration completed!");
    }
}
