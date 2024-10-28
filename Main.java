class Order {
    int orderId;
    String customerDetails;
    String orderDetails;
    Order next;

    public Order(int orderId, String customerDetails, String orderDetails) {
        this.orderId = orderId;
        this.customerDetails = customerDetails;
        this.orderDetails = orderDetails;
        this.next = null;
    }
}

class LinkedList {
    Order head;

    public void append(int orderId, String customerDetails, String orderDetails) {
        Order newOrder = new Order(orderId, customerDetails, orderDetails);
        if (head == null) {
            head = newOrder;
            return;
        }
        Order current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newOrder;
    }

    public void display() {
        Order current = head;
        while (current != null) {
            System.out.println("Order ID: " + current.orderId + ", Customer: " + current.customerDetails + ", Details: " + current.orderDetails);
            current = current.next;
        }
    }

    public void reverse() {
        Order previous = null;
        Order current = head;
        while (current != null) {
            Order next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList orderList = new LinkedList();

        // Adding orders
        orderList.append(101, "Customer A", "5 T-shirts, 2 Jeans");
        orderList.append(102, "Customer B", "1 Laptop");
        orderList.append(103, "Customer C", "3 Books");

        System.out.println("Orders before reversal:");
        orderList.display();

        // Reversing the list
        orderList.reverse();

        System.out.println("\nOrders after reversal:");
        orderList.display();
    }
}
//Time Complexity: All primary operations on the list (append, reverse, display) run in O(n) time, where
//n is the length of the list at the time of operation.
//Space Complexity: The operations do not require additional space proportional to the size of the input list, maintaining O(1) auxiliary space complexity.
//This complexity analysis confirms that while the operations are efficient in space usage, each operation's time efficiency
//depends linearly on the list's size. For applications where time performance is critical, alternative data structures like
//doubly linked lists or arrays might offer benefits like faster append operations or random access capabilities.
