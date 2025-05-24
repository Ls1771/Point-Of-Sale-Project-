import javax.swing.*;
import java.util.List;

public class CartManager {

    public static void clearCart(List<CartItem> cart, JFrame parentFrame) {
        if (cart.isEmpty()) {
            JOptionPane.showMessageDialog(parentFrame, "Cart is already empty.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                parentFrame,
                "Are you sure you want to clear the cart?",
                "Confirm",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            cart.clear();
            JOptionPane.showMessageDialog(parentFrame, "Cart cleared.");
        }
    }
    public static void removeItemById(List<CartItem> cart, JFrame parentFrame) {
        if (cart.isEmpty()) {
            JOptionPane.showMessageDialog(parentFrame, "Your cart is empty.");
            return;

        }

        String idToRemove = JOptionPane.showInputDialog(parentFrame, "Enter Product ID to remove: ");

        if (idToRemove != null && !idToRemove.isEmpty()) {
            boolean removed = cart.removeIf(item ->
                    item.getProduct().getId().equalsIgnoreCase(idToRemove.trim())
            );

            if (removed) {
                JOptionPane.showMessageDialog(parentFrame, "Cart item removed.");

            } else {
                JOptionPane.showMessageDialog(parentFrame, "Cart item not removed.");
            }
        }
    }
}
