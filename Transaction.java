
import java.util.List;

public class Transaction {
    private List<CartItem> items;
    private double TotalAmount;
    private boolean isComplete;
    private PaymentMethod paymentMethod;
    private String paymentStatus; // "COMPLETE", "FAILED", etc.

    public Transaction(List<CartItem> items) {
        this.items = items;
        this.TotalAmount = calculateTotal();
        this.isComplete = false;
    }

    public void markComplete() {
        this.isComplete = true;
    }

    public void setPaymentDetails(PaymentMethod method, String status) {
        this.paymentMethod = method;
        this.paymentStatus = status;
    }


    public double getTotalAmount() {
        return TotalAmount;
    }

    private  double calculateTotal() {
        double sum =0;
        for (CartItem item : items) {
            sum += item.getSubtotal();
        }
        return sum;
    }
}
