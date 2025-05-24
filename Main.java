import java.util.Scanner;

public class Main {
    static Product product;

    public static void main(String[] args) {
        product = new Product();


        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Product product = new Product();
            System.out.println("Enter product name: ");
            product.setProductName(scanner.nextLine());

            System.out.println("Enter product price: ");
            product.setPrice(scanner.nextDouble());
            scanner.nextLine();

            System.out.println("Enter the Id ");
            int idNumber = scanner.nextInt();
            scanner.nextLine();
            product.setId(String.valueOf(idNumber));

            System.out.println("Please enter the quantity");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            cart.addItem(product, quantity);

            System.out.println("Your new product has been created! Add another product to the cart?(yes/no)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("no")) {
                break;
            }
        }

        System.out.println("Product Name: " + product.getProductName());
       System.out.println("Product Price: " + product.getPrice());
       System.out.println("Product Id: " + product.getId());
       CartItem item = new CartItem(product, 3  );

       System.out.println("subtotal: $" + item.getSubtotal());
    }

}

//Trigger GitHub Actions
