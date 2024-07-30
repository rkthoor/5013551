public class PhonePePayment implements PaymentStrategy {
    private String email;

    public PhonePePayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PhonePe account " + email);
    }
}