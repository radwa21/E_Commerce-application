import java.util.*;
public class CustomerManager {
    private List<Customer> customerList;

    public CustomerManager() {
        customerList = new ArrayList<>();

    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public void removeCustomer(int customerID) {
        for (Customer customer : customerList) {
            if (customer.getId() == customerID) {
                customerList.remove(customerID);
                break;
            }
        }
    }

    public void viewAllCustomers() {
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }

}
