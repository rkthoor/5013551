import java.util.*;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public String productDetails() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}


class BinarySearch {
    public static void binarySearch(Product[] products, String target) {
        Arrays.sort(products, Comparator.comparing(Product::getProductName));
        int left = 0;
        int right = products.length - 1;
        int f = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(target);
            if (comparison == 0) {
                System.out.println("Product Found!");
                f = 1;
                break;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        if (f == 0)
        {
            System.out.println("Product Not Found");

        }

    }
}


class LinearSearch {
    public static void linearSearch(Product[] products, String target) {
        int f = 0;
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(target)) {
                System.out.println("Product Found!");
                f = 1;
                break;
            }
        }

        if (f == 0)
        {
        System.out.println("Product Not Found");

        }

    }
}


public class Ecommerce {
    public static void main(String[] args) {
        Product[] products = {
                new Product(1, "Laptop", "Electronics"),
                new Product(2, "Shampoo", "Personal Care"),
                new Product(3, "Smartphone", "Electronics"),
                new Product(4, "Jeans", "Clothing"),
                new Product(5, "Watch", "Accessories"),
        };

        String target = "Smartphone";

        LinearSearch.linearSearch(products, target);

        target = "BMW";

        BinarySearch.binarySearch(products, target);

    }
}