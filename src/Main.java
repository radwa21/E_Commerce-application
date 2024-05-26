import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        CustomerManager customerManager = new CustomerManager();
        OrderManager orderManager = new OrderManager();

        while (true) {
            System.out.println("\n==== eCommerce Application ====");
            System.out.println("1. Add a new product");
            System.out.println("2. Remove a product");
            System.out.println("3. View all products");
            System.out.println("4. Add a new customer");
            System.out.println("5. Remove a customer");
            System.out.println("6. View all customers");
            System.out.println("7. Create a new order");
            System.out.println("8. View all orders");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice =scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.println("\n=== Add a new product ===");
                    System.out.print("Enter product ID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter product description: ");
                    String productDescription = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double productPrice = scanner.nextDouble();
                    System.out.print("Enter product stock quantity: ");
                    int productStockQuantity = scanner.nextInt();

                    Product product = new Product(productId, productName, productDescription, productPrice, productStockQuantity);
                    productManager.addProduct(product);
                    System.out.println("Product added successfully!");
                    break;

                case 2:
                    System.out.println("\n=== Remove a product ===");
                    System.out.print("Enter product ID: ");
                    int removeProductId = scanner.nextInt();
                    productManager.removeProduct(removeProductId);
                    System.out.println("Product removed successfully!");
                    break;

                case 3:
                    System.out.println("\n=== View all products ===");
                    productManager.viewAllProducts();
                    break;

                case 4:
                    System.out.println("\n=== Add a new customer ===");
                    System.out.print("Enter customer ID: ");
                    int customerId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter customer email: ");
                    String customerEmail = scanner.nextLine();
                    System.out.print("Enter customer address: ");
                    String customerAddress = scanner.nextLine();

                    Customer customer = new Customer(customerId, customerName, customerEmail, customerAddress);
                    customerManager.addCustomer(customer);
                    System.out.println("Customer added successfully!");
                    break;

                case 5:
                    System.out.println("\n=== Remove a customer ===");
                    System.out.print("Enter customer ID: ");
                    int removeCustomerId = scanner.nextInt();
                    customerManager.removeCustomer(removeCustomerId);
                    System.out.println("Customer removed successfully!");
                    break;

                case 6:
                    System.out.println("\n=== View all customers ===");
                    customerManager.viewAllCustomers();
                    break;

                case 7:
                    System.out.println("\n=== Create a new order ===");
                    System.out.print("Enter order ID: ");
                    int orderId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter customer ID for the order: ");
                    int orderCustomerId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    List<Product> orderProductList = new ArrayList<>();
                    while (true) {
                        System.out.print("Enter product ID for the order (0 to finish): ");
                        int orderProductId = scanner.nextInt();
                        if (orderProductId == 0) {
                            break;
                        }
                        for (Product p : productManager.getProductList()) {
                            if (p.getId() == orderProductId) {
                                orderProductList.add(p);
                                break;
                            }
                        }
                    }

                    Customer orderCustomer = null;
                    for (Customer c : customerManager.getCustomerList()) {
                        if (c.getId() == orderCustomerId) {
                            orderCustomer = c;
                            break;
                        }
                    }

                    Order order = new Order(orderId, orderCustomer, orderProductList);
                    orderManager.addOrder(order);
                    System.out.println("Order created successfully!");
                    break;

                case 8:
                    System.out.println("\n=== View all orders ===");
                    orderManager.viewAllOrders();
                    break;

                case 0:
                    System.out.println("Exiting the application...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}