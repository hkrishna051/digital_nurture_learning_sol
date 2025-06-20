package Finance.java;

public class FinancialForecastingDemo {
    
}
import java.util.Scanner;

public class FinancialForecastingDemo {
    
    public static void main(String[] args) {
        System.out.println("=== FINANCIAL FORECASTING TOOL ===");
        System.out.println("Recursive Algorithm Implementation\n");
        
        RecursiveForecasting.explainRecursion();
        RecursiveForecasting.analyzeTimeComplexity();
        RecursiveForecasting.optimizationStrategies();
        
        demonstrateForecasting();
        performanceComparison();
        interactiveForecasting();
    }
    
    private static void demonstrateForecasting() {
        System.out.println("=== FORECASTING DEMONSTRATION ===");
        
        FinancialData stockData = new FinancialData(1000.0);
        stockData.addHistoricalValue(1050.0);
        stockData.addHistoricalValue(1102.5);
        stockData.addHistoricalValue(1157.63);
        stockData.addHistoricalValue(1215.51);
        stockData.addHistoricalValue(1276.29);
        
        stockData.displayData();
        System.out.println();
        
        double currentValue = stockData.getLatestValue();
        double avgGrowthRate = stockData.getAverageGrowthRate();
        int forecastPeriods = 5;
        
        System.out.println("Forecasting " + forecastPeriods + " periods ahead:");
        System.out.println("Current Value: $" + String.format("%.2f", currentValue));
        System.out.println("Average Growth Rate: " + String.format("%.2f%%", avgGrowthRate * 100));
        System.out.println("-".repeat(50));
        
        ForecastResult basicResult = RecursiveForecasting.basicRecursiveForecast(currentValue, avgGrowthRate, forecastPeriods);
        basicResult.displayResult();
        
        ForecastResult memoResult = RecursiveForecasting.memoizedRecursiveForecast(currentValue, avgGrowthRate, forecastPeriods);
        memoResult.displayResult();
        
        ForecastResult compoundResult = RecursiveForecasting.compoundRecursiveForecast(stockData, forecastPeriods);
        compoundResult.displayResult();
        
        System.out.println("=".repeat(60) + "\n");
    }
    
    private static void performanceComparison() {
        System.out.println("=== PERFORMANCE COMPARISON ===");
        
        double initialValue = 10000.0;
        double growthRate = 0.08;
        int[] testPeriods = {10, 20, 30, 50};
        
        System.out.printf("%-10s %-20s %-20s %-20s %-20s%n", 
                         "Periods", "Basic Calls", "Memoized Calls", "Basic Time (ns)", "Memoized Time (ns)");
        System.out.println("-".repeat(100));
        
        for (int periods : testPeriods) {
            ForecastResult basicResult = RecursiveForecasting.basicRecursiveForecast(initialValue, growthRate, periods);
            ForecastResult memoResult = RecursiveForecasting.memoizedRecursiveForecast(initialValue, growthRate, periods);
            
            System.out.printf("%-10d %-20d %-20d %-20d %-20d%n",
                            periods, basicResult.getRecursiveCalls(), memoResult.getRecursiveCalls(),
                            basicResult.getExecutionTime(), memoResult.getExecutionTime());
        }
        
        System.out.println("\nComparison with Iterative Approach:");
        System.out.printf("%-10s %-20s %-20s%n", "Periods", "Recursive Time (ns)", "Iterative Time (ns)");
        System.out.println("-".repeat(50));
        
        for (int periods : testPeriods) {
            ForecastResult recursiveResult = RecursiveForecasting.basicRecursiveForecast(initialValue, growthRate, periods);
            ForecastResult iterativeResult = RecursiveForecasting.iterativeForecast(initialValue, growthRate, periods);
            
            System.out.printf("%-10d %-20d %-20d%n",
                            periods, recursiveResult.getExecutionTime(), iterativeResult.getExecutionTime());
        }
        
        System.out.println("=".repeat(60) + "\n");
    }
    
    private static void interactiveForecasting() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== INTERACTIVE FINANCIAL FORECASTING ===");
        
        while (true) {
            System.out.print("Enter initial investment amount (or 'exit' to quit): $");
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting financial forecasting tool...");
                break;
            }
            
            try {
                double initialAmount = Double.parseDouble(input);
                
                System.out.print("Enter expected annual growth rate (%): ");
                double growthRatePercent = Double.parseDouble(scanner.nextLine().trim());
                double growthRate = growthRatePercent / 100.0;
                
                System.out.print("Enter number of years to forecast: ");
                int years = Integer.parseInt(scanner.nextLine().trim());
                
                System.out.println("\nForecasting Results:");
                System.out.println("Initial Amount: $" + String.format("%.2f", initialAmount));
                System.out.println("Growth Rate: " + String.format("%.2f%%", growthRatePercent));
                System.out.println("Forecast Period: " + years + " years");
                System.out.println("-".repeat(40));
                
                ForecastResult recursiveResult = RecursiveForecasting.basicRecursiveForecast(initialAmount, growthRate, years);
                ForecastResult iterativeResult = RecursiveForecasting.iterativeForecast(initialAmount, growthRate, years);
                
                recursiveResult.displayResult();
                iterativeResult.displayResult();
                
                double difference = Math.abs(recursiveResult.getForecastValue() - iterativeResult.getForecastValue());
                System.out.println("Difference between methods: $" + String.format("%.2f", difference));
                System.out.println("Performance gain (recursive vs iterative): " + 
                                 String.format("%.2fx", (double)recursiveResult.getExecutionTime() / iterativeResult.getExecutionTime()));
                
                System.out.println("\n" + "=".repeat(60) + "\n");
                
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid numbers.\n");
            }
        }
        
        scanner.close();
        
        System.out.println("\n=== RECOMMENDATIONS ===");
        System.out.println("For Financial Forecasting Applications:");
        System.out.println("✓ Use MEMOIZATION for complex multi-scenario forecasting");
        System.out.println("✓ Consider ITERATIVE approaches for simple compound growth");
        System.out.println("✓ Implement DEPTH LIMITING for user-input driven forecasts");
        System.out.println("✓ Use RECURSION for complex financial models with dependencies");
        System.out.println("✓ Cache results for repeated calculations in portfolio analysis");
    }
}
