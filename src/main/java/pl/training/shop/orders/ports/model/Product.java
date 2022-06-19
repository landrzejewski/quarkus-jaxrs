package pl.training.shop.orders.ports.model;

import lombok.Value;

@Value
public class Product {

    Long id;
    String name;
    String price;

}
