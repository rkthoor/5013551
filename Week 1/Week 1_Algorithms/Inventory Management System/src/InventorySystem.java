import java.util.*;

class InventorySystem {
    private HashMap<Integer, Product> inventory;
    private int productIdCounter;

    public InventorySystem()
    {
        inventory = new HashMap<>();
        productIdCounter = 1;
    }
    
     public void addProduct(String productName, int quantity, double price) {
        Product product = new Product(productIdCounter++, productName, quantity, price);
        inventory.put(product.getProductId(), product);
    }

    public Product getProduct(int productId)
    {
        return inventory.get(productId);
    }

    public void deleteProduct(int productId)
    {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product with ID" + productId + "does not exist");
        }
    }
    
    public void updateProduct(int productId, String productName, int quantity, double price)
    {
        Product product = inventory.get(productId);

        if (product != null) {
            if (productName != null) {
                product.setProductName(productName);
            }

            if (quantity != 0) {
                product.setQuantity(quantity);
            }

            if (price != 0) {
                product.setPrice(price);
            }
        } else {
            System.out.println("Product with productId " + productId + " does not exist.");
        }
    }
    
    public void printAllProducts() {
        if (inventory.isEmpty()) {
            System.out.println("No products in the inventory.");
        } else {
            for (Product product : inventory.values()) {
                System.out.println(product.productDetails());
            }
        }
    }

    public static void main(String args[])
    {
        InventorySystem ob = new InventorySystem();

        ob.addProduct("Paper", 1, 20.5);
        ob.addProduct("oil", 1, 0.5);
        ob.addProduct("Car", 10, 100000);

        ob.updateProduct(1, "Paper", 500, 16.5);

        ob.getProduct(1);

        ob.deleteProduct(2);

        
        ob.printAllProducts();

    }
}

