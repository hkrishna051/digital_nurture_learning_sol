package ECommerce;

public class ECommerceSearchDemo {
    
}
import java.util.Arrays;
import java.util.Scanner;

public class EcommerceSearchDemo {
    
    public static void main(String[] args) {
        System.out.println("=== E-COMMERCE PLATFORM SEARCH OPTIMIZATION ===\n");
        
        BigOAnalyzer.explainBigONotation();
        BigOAnalyzer.explainSearchCases();
        
        demonstrateSearchAlgorithms();
        performanceComparison();
        interactiveSearch();
    }
    
    private static void demonstrateSearchAlgorithms() {
        System.out.println("=== SEARCH ALGORITHM DEMONSTRATION ===");
        
        Product[] products = SearchAlgorithms.generateSampleProducts(10);
        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts);
        
        System.out.println("Sample Products (First 5):");
        for (int i = 0; i < Math.min(5, products.length); i++) {
            System.out.println((i + 1) + ". " + products[i]);
        }
        System.out.println();
        
        int searchId = products[7].getProductId();
        System.out.println("Searching for Product ID: " + searchId + "\n");
        
        SearchResult linearResult = SearchAlgorithms.linearSearch(products, searchId);
        linearResult.displayResult("LINEAR SEARCH");
        
        SearchResult binaryResult = SearchAlgorithms.binarySearch(sortedProducts, searchId);
        binaryResult.displayResult("BINARY SEARCH");
    }
    
    private static void performanceComparison() {
        System.out.println("=== PERFORMANCE COMPARISON ===");
        
        int[] testSizes = {100, 1000, 10000, 100000};
        BigOAnalyzer.analyzePerformance(testSizes);
        
        System.out.println("Real Performance Test:");
        System.out.printf("%-10s %-20s %-20s %-15s%n", 
                         "Size", "Linear Comparisons", "Binary Comparisons", "Speed Ratio");
        System.out.println("-".repeat(70));
        
        for (int size : testSizes) {
            Product[] products = SearchAlgorithms.generateSampleProducts(size);
            Product[] sortedProducts = Arrays.copyOf(products, products.length);
            Arrays.sort(sortedProducts);
            
            int targetId = products[size - 1].getProductId();
            
            SearchResult linearResult = SearchAlgorithms.linearSearch(products, targetId);
            SearchResult binaryResult = SearchAlgorithms.binarySearch(sortedProducts, targetId);
            
            double speedRatio = (double) linearResult.getComparisons() / binaryResult.getComparisons();
            
            System.out.printf("%-10d %-20d %-20d %-15.2fx%n",
                            size, linearResult.getComparisons(), 
                            binaryResult.getComparisons(), speedRatio);
        }
        System.out.println("=".repeat(60) + "\n");
    }
    
    private static void interactiveSearch() {
        Scanner scanner = new Scanner(System.in);
        Product[] products = SearchAlgorithms.generateSampleProducts(20);
        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts);
        
        System.out.println("=== INTERACTIVE SEARCH TESTING ===");
        System.out.println("Available Product IDs:");
        for (int i = 0; i < products.length; i++) {
            System.out.print(products[i].getProductId() + " ");
            if ((i + 1) % 10 == 0) System.out.println();
        }
        System.out.println("\n");
        
        while (true) {
            System.out.print("Enter Product ID to search (or 'exit' to quit): ");
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting search demo...");
                break;
            }
            
            try {
                int searchId = Integer.parseInt(input);
                
                System.out.println("\nSearching for Product ID: " + searchId);
                
                SearchResult linearResult = SearchAlgorithms.linearSearch(products, searchId);
                SearchResult binaryResult = SearchAlgorithms.binarySearch(sortedProducts, searchId);
                
                linearResult.displayResult("LINEAR SEARCH");
                binaryResult.displayResult("BINARY SEARCH");
                
                if (linearResult.isFound() && binaryResult.isFound()) {
                    System.out.println("Performance Comparison:");
                    System.out.println("Linear Search Comparisons: " + linearResult.getComparisons());
                    System.out.println("Binary Search Comparisons: " + binaryResult.getComparisons());
                    System.out.println("Binary Search is " + 
                                     (linearResult.getComparisons() / (double) binaryResult.getComparisons()) + 
                                     "x faster\n");
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number or 'exit'\n");
            }
        }
        
        scanner.close();
        
        System.out.println("\n=== ALGORITHM RECOMMENDATION ===");
        System.out.println("For E-commerce Platform Search:");
        System.out.println("✓ BINARY SEARCH is recommended because:");
        System.out.println("  • O(log n) time complexity vs O(n) for linear search");
        System.out.println("  • Scales much better with large product catalogs");
        System.out.println("  • Provides consistent fast performance");
        System.out.println("  • Product IDs can be easily maintained in sorted order");
        System.out.println("\n✓ CONSIDERATIONS:");
        System.out.println("  • Requires sorted data (one-time cost)");
        System.out.println("  • For frequently updated catalogs, consider balanced trees");
        System.out.println("  • For text search, consider hash tables or search engines");
    }
}
