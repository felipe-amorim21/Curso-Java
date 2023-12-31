import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;

    private List<OrderItem> orderItems = new ArrayList<>();
    private Client client;

    Order(){}

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item){
        orderItems.add(item);
    }

    public void removeItem(OrderItem item){
        orderItems.remove(item);
    }

    public Double total(){
        double sum = 0;

        for(OrderItem o : orderItems){
            sum += o.subTotal();
        }

        return sum;
    }
}
