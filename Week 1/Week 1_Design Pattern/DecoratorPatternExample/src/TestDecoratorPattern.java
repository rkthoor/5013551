public class TestDecoratorPattern {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        
        Notifier smsAndEmailNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackAndEmailNotifier = new SlackNotifierDecorator(emailNotifier);
        
        System.out.println("Sending notification through SMS and Email:");
        smsAndEmailNotifier.send("Hello, this is a test notification!");

        System.out.println("\nSending notification through Slack and Email:");
        slackAndEmailNotifier.send("Hello, this is another test notification!");
    }
}
