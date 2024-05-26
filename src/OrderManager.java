import java.util.*;
public class OrderManager {
    private List<Order> orderList ;

    public OrderManager() {
        orderList = new ArrayList<>();
    }

    public void addOrder(Order order){
        orderList.add(order);
    }

    public void removeOrder(int orderId){
        for(Order order : orderList ){
            if(order.getId() == orderId){
                orderList.remove(order);
                break;
            }
        }
    }

    public void viewAllOrders(){
        for (Order order : orderList ){
            System.out.println(order.toString());
        }
    }

}
