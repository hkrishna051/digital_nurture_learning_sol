package Finance.java;

public class RecursiveForecasting {
    
}
import java.util.HashMap;
import java.util.Map;

class RecursiveForecasting {
    private static int callCounter;
    private static Map<String, Double> memoCache;
    
    public static ForecastResult basicRecursiveForecast(double currentValue, double growthRate, int periods) {
        callCounter = 0;
        long startTime = System.nanoTime();
        
        double result = calculateFutureValueBasic(currentValue, growthRate, periods);
        
        long endTime = System.nanoTime();
        return new ForecastResult(result, callCounter, endTime - startTime, "Basic Recursive");
    }
    
    private static double calculateFutureValueBasic(double currentValue, double growthRate, int periods) {
        callCounter++;
        
        if (periods == 0) {
            return currentValue;
        }
        
        return calculateFutureValueBasic(currentValue * (1 + growthRate), growthRate, periods - 1);
    }
    
    public static ForecastResult memoizedRecursiveForecast(double currentValue, double growthRate, int periods) {
        callCounter = 0;
        memoCache = new HashMap<>();
        long startTime = System.nanoTime();
        
        double result = calculateFutureValueMemoized(currentValue, growthRate, periods);
        
        long endTime = System.nanoTime();
        return new ForecastResult(result, callCounter, endTime - startTime, "Memoized Recursive");
    }
    
    private static double calculateFutureValueMemoized(double currentValue, double growthRate, int periods) {
        callCounter++;
        
        String key = currentValue + "," + growthRate + "," + periods;
        if (memoCache.containsKey(key)) {
            return memoCache.get(key);
        }
        
        if (periods == 0) {
            memoCache.put(key, currentValue);
            return currentValue;
        }
        
        double result = calculateFutureValueMemoized(currentValue * (1 + growthRate), growthRate, periods - 1);
        memoCache.put(key, result);
        return result;
    }
    
    public static ForecastResult compoundRecursiveForecast(FinancialData data, int periods) {
        callCounter = 0;
        long startTime = System.nanoTime();
        
        double result = calculateCompoundForecast(data.getLatestValue(), data.getGrowthRates(), 0, periods);
        
        long endTime = System.nanoTime();
        return new ForecastResult(result, callCounter, endTime - startTime, "Compound Recursive");
    }
    
    private static double calculateCompoundForecast(double currentValue, java.util.List<Double> growthRates, int currentPeriod, int totalPeriods) {
        callCounter++;
        
        if (currentPeriod >= totalPeriods) {
            return currentValue;
        }
        
        double growthRate = growthRates.get(currentPeriod % growthRates.size());
        double nextValue = currentValue * (1 + growthRate);
        
        return calculateCompoundForecast(nextValue, growthRates, currentPeriod + 1, totalPeriods);
    }
    
    public static ForecastResult iterativeForecast(double currentValue, double growthRate, int periods) {
        long startTime = System.nanoTime();
        
        double result = currentValue;
        for (int i = 0; i < periods; i++) {
            result *= (1 + growthRate);
        }
        
        long endTime = System.nanoTime();
        return new ForecastResult(result, 0, endTime - startTime, "Iterative (Non-Recursive)");
    }
    
    public static void explainRecursion() {
        System.out.println("=== UNDERSTANDING RECURSION ===");
        System.out.println("Recursion is a programming technique where a function calls itself to solve smaller");
        System.out.println("instances of the same problem. It consists of two essential parts:");
        System.out.println("1. BASE CASE: The condition that stops the recursion");
        System.out.println("2. RECURSIVE STEP: The function calling itself with modified parameters\n");
        
        System.out.println("Benefits of Recursion in Financial Forecasting:");
        System.out.println("• Simplifies complex compound growth calculations");
        System.out.println("• Natural representation of time-based financial models");
        System.out.println("• Elegant solution for multi-period forecasting");
        System.out.println("• Easy to understand and maintain\n");
        
        System.out.println("Challenges:");
        System.out.println("• Can be computationally expensive for large periods");
        System.out.println("• Risk of stack overflow for deep recursion");
        System.out.println("• May recalculate same values multiple times");
        System.out.println("=".repeat(60) + "\n");
    }
    
    public static void analyzeTimeComplexity() {
        System.out.println("=== TIME COMPLEXITY ANALYSIS ===");
        System
