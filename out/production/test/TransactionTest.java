import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    @Test
    public void testCalculateTotal() {
        List<CartItem> items = new ArrayList<>();
        Product apple = new Product("Apple", 1.00, "A100");
        Product milk = new Product("Milk", 3.00, "M200");

        items.add(new CartItem(apple, 2));
        items.add(new CartItem(milk, 1));

        Transaction transaction = new Transaction(items);

        assertEquals(5.00, transaction.getTotalAmount(), 0.001);
    }

}
