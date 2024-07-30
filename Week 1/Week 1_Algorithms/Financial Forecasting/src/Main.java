public class Main {

    public static double calculateFutureValue(double pv, double r, int n) {
        if (n == 0) {
            return pv;
        }
        return calculateFutureValue(pv * (1 + r), r, n - 1);
    }

    public static void main(String[] args) {
        double presentValue = 1000; 
        double annualInterestRate = 0.05;
        int years = 10; 

        double futureValue = calculateFutureValue(presentValue, annualInterestRate, years);
        System.out.println("Future Value: " + futureValue);
    }
}
