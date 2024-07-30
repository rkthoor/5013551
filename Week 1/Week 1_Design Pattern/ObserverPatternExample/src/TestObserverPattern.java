public class TestObserverPattern {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket("AAPL", 150.00);

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        System.out.println("Updating stock price to $155.00");
        stockMarket.setStockPrice(155.00);

        System.out.println("\nUpdating stock price to $160.00");
        stockMarket.setStockPrice(160.00);

        stockMarket.deregisterObserver(mobileApp);

        System.out.println("\nUpdating stock price to $165.00");
        stockMarket.setStockPrice(165.00);
    }
}
