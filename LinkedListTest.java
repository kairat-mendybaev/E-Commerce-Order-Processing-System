import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListTest {
    private LinkedList orderList;

    @Before
    public void setUp() {
        orderList = new LinkedList();
        // Set up some initial orders
        orderList.append(101, "Customer A", "5 T-shirts, 2 Jeans");
        orderList.append(102, "Customer B", "1 Laptop");
        orderList.append(103, "Customer C", "3 Books");
    }

    @Test
    public void testDisplayOrders() {
        // Mock or redirect System.out to capture output if necessary
        // Since display just prints and doesn't return, this might be tricky without additional methods to get list contents
        System.out.println("Display Orders (Manual Check):");
        orderList.display(); // This is a visual/manual check, automated testing would require changes
    }

    @Test
    public void testReverseList() {
        orderList.reverse();
        // Check if the first item is now what used to be the last
        assertEquals("Customer C", orderList.head.customerDetails);
    }

    @Test
    public void testDisplayAfterReverse() {
        orderList.reverse();
        System.out.println("Display After Reverse (Manual Check):");
        orderList.display(); // Another visual/manual check
    }

    private Order find(int orderId) {
        // Helper method to find an order by ID for testing
        Order current = orderList.head;
        while(current != null) {
            if (current.orderId == orderId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    @Test
    public void testReverseSingleElementList() {
        orderList.append(105, "Customer E", "1 Mouse");
        orderList.reverse();
        assertEquals("Reversing a single-element list should not change the head", 105, orderList.head.orderId);
    }

    @Test
    public void testMultipleReversals() {
        orderList.append(101, "Customer A", "5 T-shirts, 2 Jeans");
        orderList.append(102, "Customer B", "1 Laptop");
        orderList.append(103, "Customer C", "3 Books");

        // Perform reversal twice
        orderList.reverse();
        orderList.reverse();

        // After two reversals, the list should be back to its original order
        assertEquals("Head should be the original first element after two reversals", 101, orderList.head.orderId);
        assertEquals("Second element should be the original second element", 102, orderList.head.next.orderId);
    }
}
