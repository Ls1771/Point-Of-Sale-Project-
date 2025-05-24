
import java.util.Random;

public class PaymentService {
    public boolean processPayment(PaymentMethod method) {
        // Simulate success/failure randomly
        return new Random().nextBoolean(); // For demo only
    }
}
