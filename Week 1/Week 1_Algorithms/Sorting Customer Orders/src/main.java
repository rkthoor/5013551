class Order {
    private int orderId;
    private String customerName;
    private int totalPrice;

    public Order(int orderId, String customerName, int totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

}

class BubbleSort {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }
}

class QuickSort {
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
}

public class main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "A", 250),
            new Order(2, "B", 150),
            new Order(3, "C", 300),
            new Order(4, "D", 200)
        };

        System.out.println("Original Orders:");
        for (Order order : orders) {
            System.out.println(order.getTotalPrice());
        }

        // Bubble Sort
        Order[] bubbleSortedOrders = orders;
        BubbleSort.bubbleSort(bubbleSortedOrders);
        System.out.println("\nBubble Sorted Orders:");
        for (Order order : bubbleSortedOrders) {
            System.out.println(order.getTotalPrice());
        }

        // Quick Sort
        // Reinitialize the orders array to original order
        orders = new Order[]{
            new Order(1, "A", 250),
            new Order(2, "B", 150),
            new Order(3, "C", 300),
            new Order(4, "D", 200)
        };

        Order[] quickSortedOrders = orders;
        QuickSort.quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        System.out.println("\nQuick Sorted Orders:");
        for (Order order : quickSortedOrders) {
            System.out.println(order.getTotalPrice());
        }
    }
}

