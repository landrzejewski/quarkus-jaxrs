package pl.training.shop.orders.ports.output;

import pl.training.shop.orders.ports.model.Product;

import java.util.Optional;

public interface ProductsProvider {

    Optional<Product> getById(Long id);

}
