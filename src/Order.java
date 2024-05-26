
import java.util.*;
class Order {
    private int id;
    private Customer customer;
    private List<Product> productList;
    private double totalAmount;

    public Order(int id, Customer customer, List<Product> productList) {
        this.id = id;
        this.customer = customer;
        this.productList = productList;
        this.totalAmount = calculateTotalAmount();
    }

    private double calculateTotalAmount() {
        double total = 0.0;
        for (Product product : productList) {
            total += product.getPrice();
        }
        return total;
    }

    // Getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String toString() {
        return "Order ID: " + id + ", Customer: " + customer.getName() + ", Total Amount: " + totalAmount;
    }
}