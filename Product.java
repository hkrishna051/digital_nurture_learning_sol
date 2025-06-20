package ECommerce;

public class Product {
    
}
class Product implements Comparable<Product> {
    private int productId;
    private String productName;
    private String category;
    private double price;
    
    public Product(int productId, String productName, String category, double price) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
    }
    
    public int getProductId() {
        return productId;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public String getCategory() {
        return category;
    }
    
    public double getPrice() {
        return price;
    }
    
    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.productId, other.productId);
    }
    
    @Override
    public String toString() {
        return String.format("Product{ID=%d, Name='%s', Category='%s', Price=$%.2f}", 
                           productId, productName, category, price);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return productId == product.productId;
    }
}

class SearchResult {
    private Product product;
    private int comparisons;
    private long executionTime;
    private boolean found;
    
    public SearchResult(Product product, int comparisons, long executionTime, boolean found) {
        this.product = product;
        this.comparisons = comparisons;
        this.executionTime = executionTime;
        this.found = found;
    }
    
    public Product getProduct() {
        return product;
    }
    
    public int getComparisons() {
        return comparisons;
    }
    
    public long getExecutionTime() {
        return executionTime;
    }
    
    public boolean isFound() {
        return found;
    }
    
    public void displayResult(String algorithmName) {
        System.out.println(algorithmName + " Results:");
        System.out.println("Found: " + found);
        if (found) {
            System.out.println("Product: " + product);
        }
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Execution Time: " + executionTime + " nanoseconds");
        System.out.println("-".repeat(50));
    }
}
