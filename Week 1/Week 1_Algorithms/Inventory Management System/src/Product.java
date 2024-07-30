public class Product {

    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId,String productName, int quantity, double price)
    {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId()
    {
        return productId;
    }

    public String getProductName()
    {
        return productName;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public double getPrice()
    {
        return price;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    public void setPrice(double price)
    {
        this.price = price ;
    }

   public String productDetails()
   {
       String x = "Product {" + " productId = " + productId + " productName = " + productName + " quantity =  " + quantity
               + " price " + price + "}";
       return x;
   }
}
