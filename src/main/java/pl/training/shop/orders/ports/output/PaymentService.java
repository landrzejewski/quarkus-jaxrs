package pl.training.shop.orders.ports.output;

import pl.training.shop.orders.ports.model.Payment;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

public interface PaymentService {

    Optional<Payment> pay(Long requestId, BigDecimal value, String currency, Map<String, String> properties);

}
