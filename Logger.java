// Logger.java - Singleton Logger Class
public class Logger {
    private static Logger instance;
    
    private Logger() {
        System.out.println("Logger instance created successfully!");
    }
    
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    
    public void logInfo(String message) {
        System.out.println("[INFO] " + getCurrentTimestamp() + " - " + message);
    }

    public void logError(String message) {
        System.out.println("[ERROR] " + getCurrentTimestamp() + " - " + message);
    }

    public void logWarning(String message) {
        System.out.println("[WARNING] " + getCurrentTimestamp() + " - " + message);
    }

    private String getCurrentTimestamp() {
        return java.time.LocalDateTime.now().toString();
    }

    public void displayLoggerInfo() {
        System.out.println("Logger Instance Hash Code: " + this.hashCode());
        System.out.println("Logger Class: " + this.getClass().getSimpleName());
    }
}
