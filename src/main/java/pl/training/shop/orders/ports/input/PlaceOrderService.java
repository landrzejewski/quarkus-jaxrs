package pl.training.shop.orders.ports.input;

import pl.training.shop.orders.ports.model.Order;

public interface PlaceOrderService {

    void place(Order order);

}
