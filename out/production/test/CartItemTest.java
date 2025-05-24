import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartItemTest {

    @Test
    public void testGetSubtotal() {
        Product banana = new Product("Banana", 1.50, "B4011");
        CartItem item = new CartItem(banana, 4);  // $1.50 × 4 = $6.00

        double expected = 6.00;
        double actual = item.getSubtotal();

        assertEquals(expected, actual, 0.001);
    }
    @Test
    public void testSubtotalWithZeroQuantity() {
        Product soda = new Product("Soda", 2.00, "S2000");
        CartItem item = new CartItem(soda, 0);  // 0 quantity

        double expected = 0.00;
        double actual = item.getSubtotal();

        assertEquals(expected, actual, 0.001);
    }

}
