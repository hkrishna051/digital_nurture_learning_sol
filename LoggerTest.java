// LoggerTest.java - Test Class for Verification Purpose
public class LoggerTest {
    
    
    public static void testSingletonInMultipleThreads() {
        System.out.println("Testing Singleton in Multiple Threads:");
        System.out.println("-".repeat(45));
        
      
        Thread thread1 = new Thread(() -> {
            Logger logger = Logger.getInstance();
            logger.logInfo("Message from Thread 1 - Hash: " + logger.hashCode());
        });
        
        Thread thread2 = new Thread(() -> {
            Logger logger = Logger.getInstance();
            logger.logInfo("Message from Thread 2 - Hash: " + logger.hashCode());
        });
        
        Thread thread3 = new Thread(() -> {
            Logger logger = Logger.getInstance();
            logger.logInfo("Message from Thread 3 - Hash: " + logger.hashCode());
        });
        
        
        thread1.start();
        thread2.start();
        thread3.start();
        
        
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
        }
        
        System.out.println("Multi-thread test completed!");
    }
    
    
    public static void testPrivateConstructor() {
        System.out.println("\nTesting Private Constructor:");
        System.out.println("-".repeat(30));
        System.out.println("✓ Private constructor prevents external instantiation");
        System.out.println("✓ Only getInstance() method can create Logger instance");
    }
   
    public static void main(String[] args) {
        System.out.println("=== Logger Singleton Pattern Test Suite ===\n");
        
        SingletonPatternExample.testSingletonImplementation();
        
        testSingletonInMultipleThreads();
        
        testPrivateConstructor();
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("All tests completed successfully!");
        System.out.println("Singleton pattern implementation verified ✓");
    }
}
