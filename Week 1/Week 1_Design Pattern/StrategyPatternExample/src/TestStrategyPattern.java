// src/TestStrategyPattern.java
public class TestStrategyPattern {
    public static void main(String[] args) {
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432");
        PaymentStrategy phonePePayment = new PhonePePayment("user@example.com");

        PaymentContext paymentContext = new PaymentContext(creditCardPayment);
        System.out.println("Processing payment with Credit Card:");
        paymentContext.executePayment(100.00);

        paymentContext = new PaymentContext(phonePePayment);
        System.out.println("\nProcessing payment with PhonePe:");
        paymentContext.executePayment(200.00);
    }
}
