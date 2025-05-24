import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReceiptPrinter {

    public static void printReceipt(List<CartItem> cart) throws IOException {
        StringBuilder receipt = new StringBuilder();
        receipt.append("===== POS-R-Us Receipt =====\n\n");

        double total = 0;

        for (CartItem item : cart) {
            Product p = item.getProduct();
            int qty = (int) (item.getSubtotal() / p.getPrice());
            double subtotal = item.getSubtotal();

            receipt.append(String.format("%-15s x%d  $%.2f\n", p.getProductName(), qty, subtotal));
            total += subtotal;
        }

        receipt.append("\n-----------------------------\n");
        receipt.append(String.format("TOTAL: $%.2f\n", total));
        receipt.append("Thank you for shopping with us!");

        Files.write(Paths.get("receipt.txt"), receipt.toString().getBytes());
    }
}
