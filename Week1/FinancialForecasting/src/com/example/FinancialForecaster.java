package com.example;


public class FinancialForecaster {

 
 public static double calculateFutureValueRecursive(double presentValue, double growthRate, int periods) {
     
     if (periods == 0) {
         return presentValue;
     }
     
     else {
         double valuePreviousPeriod = calculateFutureValueRecursive(presentValue, growthRate, periods - 1);
         return valuePreviousPeriod * (1 + growthRate);
         
     }
 }

 
 public static double calculateFutureValueIterative(double presentValue, double growthRate, int periods) {
     double futureValue = presentValue;
     for (int i = 0; i < periods; i++) {
         futureValue *= (1 + growthRate);
     }
     return futureValue;
 }


 public static void main(String[] args) {
     double initialInvestment = 1000.0; // $1000
     double annualGrowthRate = 0.05;    // 5%
     int numberOfPeriods = 10;          // 10 years

     System.out.println("--- Financial Forecasting Tool ---");

     
     System.out.println("\nUsing Recursive Approach:");
     double futureValueRecursive = calculateFutureValueRecursive(initialInvestment, annualGrowthRate, numberOfPeriods);
     System.out.printf("Initial Investment: $%.2f\n", initialInvestment);
     System.out.printf("Annual Growth Rate: %.2f%%\n", annualGrowthRate * 100);
     System.out.printf("Number of Periods: %d years\n", numberOfPeriods);
     System.out.printf("Future Value: $%.2f\n", futureValueRecursive);

     
     System.out.println("\nTesting Base Case (0 periods):");
     double futureValueZeroPeriods = calculateFutureValueRecursive(initialInvestment, annualGrowthRate, 0);
     System.out.printf("Future Value (0 periods): $%.2f\n", futureValueZeroPeriods);

     
     System.out.println("\nUsing Iterative Approach (for comparison):");
     double futureValueIterative = calculateFutureValueIterative(initialInvestment, annualGrowthRate, numberOfPeriods);
     System.out.printf("Future Value (Iterative): $%.2f\n", futureValueIterative);

     

 }
}
