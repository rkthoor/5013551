public class TestAdapterPattern {
    public static void main(String[] args) {
        // Using PhonePe through the adapter
        PhonePeGateway phonePeGateway = new PhonePeGateway();
        PaymentProcessor phonePeAdapter = new PhonePeAdapter(phonePeGateway);
        phonePeAdapter.processPayment(100.0);

        // Using Paytm through the adapter
        PaytmGateway paytmGateway = new PaytmGateway();
        PaymentProcessor paytmAdapter = new PaytmAdapter(paytmGateway);
        paytmAdapter.processPayment(200.0);
    }
}
