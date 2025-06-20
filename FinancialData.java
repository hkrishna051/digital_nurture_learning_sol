package Finance.java;

public class FinancialData {
    
}
import java.util.ArrayList;
import java.util.List;

class FinancialData {
    private double initialValue;
    private List<Double> growthRates;
    private String assetName;
    
    public FinancialData(String assetName, double initialValue) {
        this.assetName = assetName;
        this.initialValue = initialValue;
        this.growthRates = new ArrayList<>();
    }
    
    public void addGrowthRate(double rate) {
        growthRates.add(rate);
    }
    
    public double getInitialValue() {
        return initialValue;
    }
    
    public List<Double> getGrowthRates() {
        return growthRates;
    }
    
    public String getAssetName() {
        return assetName;
    }
    
    public double getAverageGrowthRate() {
        if (growthRates.isEmpty()) return 0.0;
        return growthRates.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }
}

class ForecastResult {
    private double futureValue;
    private int recursiveCalls;
    private long executionTime;
    private int periods;
    
    public ForecastResult(double futureValue, int recursiveCalls, long executionTime, int periods) {
        this.futureValue = futureValue;
        this.recursiveCalls = recursiveCalls;
        this.executionTime = executionTime;
        this.periods = periods;
    }
    
    public double getFutureValue() {
        return futureValue;
    }
    
    public int getRecursiveCalls() {
        return recursiveCalls;
    }
    
    public long getExecutionTime() {
        return executionTime;
    }
    
    public int getPeriods() {
        return periods;
    }
    
    public void displayResult(String method) {
        System.out.println(method + " Forecast Results:");
        System.out.printf("Future Value: $%.2f%n", futureValue);
        System.out.println("Periods: " + periods);
        System.out.println("Recursive Calls: " + recursiveCalls);
        System.out.println("Execution Time: " + executionTime + " nanoseconds");
        System.out.println("-".repeat(50));
    }
}
