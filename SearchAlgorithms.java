package ECommerce;

public class SearchAlgorithms {
    
}
import java.util.Arrays;
import java.util.Random;

class SearchAlgorithms {
    
    public static SearchResult linearSearch(Product[] products, int targetId) {
        long startTime = System.nanoTime();
        int comparisons = 0;
        
        for (int i = 0; i < products.length; i++) {
            comparisons++;
            if (products[i].getProductId() == targetId) {
                long endTime = System.nanoTime();
                return new SearchResult(products[i], comparisons, endTime - startTime, true);
            }
        }
        
        long endTime = System.nanoTime();
        return new SearchResult(null, comparisons, endTime - startTime, false);
    }
    
    public static SearchResult binarySearch(Product[] sortedProducts, int targetId) {
        long startTime = System.nanoTime();
        int comparisons = 0;
        int left = 0;
        int right = sortedProducts.length - 1;
        
        while (left <= right) {
            comparisons++;
            int mid = left + (right - left) / 2;
            
            if (sortedProducts[mid].getProductId() == targetId) {
                long endTime = System.nanoTime();
                return new SearchResult(sortedProducts[mid], comparisons, endTime - startTime, true);
            }
            
            if (sortedProducts[mid].getProductId() < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        long endTime = System.nanoTime();
        return new SearchResult(null, comparisons, endTime - startTime, false);
    }
    
    public static Product[] generateSampleProducts(int count) {
        Product[] products = new Product[count];
        String[] categories = {"Electronics", "Clothing", "Books", "Home", "Sports", "Beauty"};
        String[] productNames = {"Laptop", "Smartphone", "Tablet", "Headphones", "Camera", 
                               "Shirt", "Jeans", "Shoes", "Watch", "Bag"};
        Random random = new Random();
        
        for (int i = 0; i < count; i++) {
            int id = (i + 1) * 10;
            String name = productNames[random.nextInt(productNames.length)] + " " + (i + 1);
            String category = categories[random.nextInt(categories.length)];
            double price = 10.0 + (random.nextDouble() * 990.0);
            
            products[i] = new Product(id, name, category, price);
        }
        
        return products;
    }
    
    public static void shuffleArray(Product[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Product temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}

class BigOAnalyzer {
    
    public static void explainBigONotation() {
        System.out.println("=== BIG O NOTATION EXPLANATION ===");
        System.out.println("Big O notation describes how algorithm performance scales with input size.");
        System.out.println("It focuses on the worst-case scenario and ignores constants and lower-order terms.\n");
        
        System.out.println("Common Big O Complexities:");
        System.out.println("O(1) - Constant time: Same performance regardless of input size");
        System.out.println("O(log n) - Logarithmic time: Performance increases slowly with input size");
        System.out.println("O(n) - Linear time: Performance increases proportionally with input size");
        System.out.println("O(n²) - Quadratic time: Performance increases quadratically with input size");
        System.out.println("=".repeat(60) + "\n");
    }
    
    public static void explainSearchCases() {
        System.out.println("=== SEARCH ALGORITHM CASES ===");
        System.out.println("LINEAR SEARCH:");
        System.out.println("• Best Case: O(1) - Element found at first position");
        System.out.println("• Average Case: O(n/2) ≈ O(n) - Element found in middle");
        System.out.println("• Worst Case: O(n) - Element at last position or not found\n");
        
        System.out.println("BINARY SEARCH:");
        System.out.println("• Best Case: O(1) - Element found at middle position");
        System.out.println("• Average Case: O(log n) - Typical search performance");
        System.out.println("• Worst Case: O(log n) - Element at leaf level or not found");
        System.out.println("• Prerequisite: Array must be sorted");
        System.out.println("=".repeat(60) + "\n");
    }
    
    public static void analyzePerformance(int[] dataSizes) {
        System.out.println("=== PERFORMANCE ANALYSIS ===");
        System.out.printf("%-10s %-15s %-15s %-15s %-15s%n", 
                         "Size", "Linear Best", "Linear Worst", "Binary Best", "Binary Worst");
        System.out.println("-".repeat(75));
        
        for (int size : dataSizes) {
            System.out.printf("%-10d %-15d %-15d %-15d %-15d%n",
                            size, 1, size, 1, (int)(Math.log(size) / Math.log(2)));
        }
        System.out.println("=".repeat(60) + "\n");
    }
}
