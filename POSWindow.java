import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class POSWindow extends JFrame {

    private List<CartItem> cart = new ArrayList<>();

    public POSWindow() {
        setTitle("POS-R-Us");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Barcode input
        JLabel barcodeLabel = new JLabel("Product ID:");
        barcodeLabel.setBounds(30, 30, 100, 25);
        add(barcodeLabel);

        JTextField barcodeField = new JTextField();
        barcodeField.setBounds(130, 30, 150, 25);
        add(barcodeField);

        JButton scanButton = new JButton("Scan");
        scanButton.setBounds(300, 30, 100, 25);
        add(scanButton);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 70, 100, 25);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(130, 70, 150, 25);
        nameField.setEditable(false);
        add(nameField);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(30, 110, 100, 25);
        add(priceLabel);

        JTextField priceField = new JTextField();
        priceField.setBounds(130, 110, 150, 25);
        priceField.setEditable(false);
        add(priceField);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(30, 150, 100, 25);
        add(quantityLabel);

        JTextField quantityField = new JTextField();
        quantityField.setBounds(130, 150, 150, 25);
        add(quantityField);

        JButton addButton = new JButton("Add to Cart");
        addButton.setBounds(130, 190, 150, 25);
        add(addButton);

        JButton viewCartButton = new JButton("View Cart");
        viewCartButton.setBounds(130, 230, 150, 25);
        add(viewCartButton);

        JButton printButton = new JButton("Print Receipt");
        printButton.setBounds(130, 270, 150, 25);
        add(printButton);

        JButton clearCartButton = new JButton("Clear Cart");
        clearCartButton.setBounds(300, 230, 150, 25);
        add(clearCartButton);

        JButton removeItemButton = new JButton("Remove Item");
        removeItemButton.setBounds(300, 270, 150, 25);
        add(removeItemButton);

        removeItemButton.addActionListener(e -> {
            CartManager.removeItemById(cart, this);
        });


        // Scan button action
        scanButton.addActionListener(e -> {
            String id = barcodeField.getText().trim();
            Product found = findProductById(id);
            if (found != null) {
                nameField.setText(found.getProductName());
                priceField.setText(String.valueOf(found.getPrice()));
            } else {
                nameField.setText("Not found");
                priceField.setText("");
            }
        });

        // Add to cart action
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String priceText = priceField.getText();
            String id = barcodeField.getText().trim();
            String qtyText = quantityField.getText();

            if (name.equals("") || priceText.equals("") || qtyText.equals("")) {
                JOptionPane.showMessageDialog(this, "Please scan your items and enter amount.");
                return;
            }

            try {
                double price = Double.parseDouble(priceText);
                int quantity = Integer.parseInt(qtyText);
                Product product = new Product(name, price, id);
                cart.add(new CartItem(product, quantity));
                JOptionPane.showMessageDialog(this, "Item added successfully.");

                barcodeField.setText("");
                nameField.setText("");
                priceField.setText("");
                quantityField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number format.");
            }
        });

        // View cart action
        viewCartButton.addActionListener(e -> {
            if (cart.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Your cart is empty.");
                return;
            }

            StringBuilder summary = new StringBuilder();
            double total = 0;

            for (CartItem item : cart) {
                Product p = item.getProduct();
                int qty = (int)(item.getSubtotal() / p.getPrice());
                double subtotal = item.getSubtotal();
                summary.append(p.getProductName()).append(" x").append(qty)
                        .append(" = $").append(String.format("%.2f", subtotal)).append("\n");
                total += subtotal;
            }

            summary.append("\nTotal: $").append(String.format("%.2f", total));
            JOptionPane.showMessageDialog(this, summary.toString(), "Cart Summary", JOptionPane.INFORMATION_MESSAGE);
        });

        // Print receipt action
        printButton.addActionListener(e -> {
            if (cart.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Cart is empty. Nothing to print.");
                return;
            }

            try {
                ReceiptPrinter.printReceipt(cart);
                JOptionPane.showMessageDialog(this, "Receipt saved to receipt.txt!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving receipt: " + ex.getMessage());
            }
        });

        clearCartButton.addActionListener( e-> {
            CartManager.clearCart(cart, this);
        });
    }

    // Simple product lookup
    private Product findProductById(String id) {
        if (id.equals("A100")) {
            return new Product("Apple", 1.25, "A100");
        } else if (id.equals("M200")) {
            return new Product("Milk", 3.50, "M200");
        }
        return null;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            POSWindow window = new POSWindow();
            window.setVisible(true);
        });
    }
}

