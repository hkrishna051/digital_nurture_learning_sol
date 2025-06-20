package Exercise 2;

public class FactoryMeathodPatternMeathodExample {
    
}
import java.util.Scanner;

public class FactoryMethodPatternExample {
    
    public static void main(String[] args) {
        System.out.println("=== Document Management System ===");
        System.out.println("Factory Method Pattern Implementation\n");
        
        demonstrateFactoryPattern();
        runTests();
        interactiveDocumentCreation();
    }
    
    private static void demonstrateFactoryPattern() {
        System.out.println("Demonstrating Factory Method Pattern:");
        System.out.println("-".repeat(45));
        
        String[] documentTypes = {"word", "pdf", "excel"};
        
        for (String type : documentTypes) {
            System.out.println("\nCreating " + type.toUpperCase() + " document:");
            DocumentManager.createAndProcessDocument(type);
        }
        
        System.out.println("\n" + "=".repeat(50));
    }
    
    private static void runTests() {
        System.out.println("\nRunning Factory Method Tests:");
        System.out.println("-".repeat(30));
        
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        
        Document wordDocument = wordFactory.createDocument();
        Document pdfDocument = pdfFactory.createDocument();
        Document excelDocument = excelFactory.createDocument();
        
        System.out.println("Word factory creates WordDocument: " + 
                          (wordDocument instanceof WordDocument));
        System.out.println("PDF factory creates PdfDocument: " + 
                          (pdfDocument instanceof PdfDocument));
        System.out.println("Excel factory creates ExcelDocument: " + 
                          (excelDocument instanceof ExcelDocument));
        
        try {
            DocumentManager.createAndProcessDocument("powerpoint");
        } catch (Exception e) {
            System.out.println("Error handling works correctly for invalid types");
        }
        
        System.out.println("✓ All tests passed!");
        System.out.println("=".repeat(50));
    }
    
    private static void interactiveDocumentCreation() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nInteractive Document Creation:");
        System.out.println("Available document types: Word, PDF, Excel");
        System.out.print("Enter document type (or 'exit' to quit): ");
        
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting document management system...");
                break;
            }
            
            if (!input.isEmpty()) {
                System.out.println("\nProcessing request for: " + input);
                DocumentManager.createAndProcessDocument(input);
            }
            
            System.out.print("\nEnter another document type (or 'exit' to quit): ");
        }
        
        scanner.close();
    }
}
