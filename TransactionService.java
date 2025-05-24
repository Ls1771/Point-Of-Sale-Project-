
import java.util.ArrayList;
import java.util.List;

public class TransactionService {
    private List<Transaction> transactionHistory = new ArrayList<>();
    private PaymentService paymentService = new PaymentService();

    public String processCardTransaction(Transaction transaction, PaymentMethod method) {
        boolean success = paymentService.processPayment(method);
        if (success) {
            transaction.setPaymentDetails(method, "COMPLETE");
            transaction.markComplete();
            transactionHistory.add(transaction);
            return "Payment Complete";
        } else {
            transaction.setPaymentDetails(method, "FAILED");
            return "Transaction Failed. Please Try Again.";
        }
    }

    public List<Transaction> getAllTransactions() {
        return transactionHistory;
    }
}
