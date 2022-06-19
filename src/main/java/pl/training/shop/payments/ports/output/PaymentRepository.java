package pl.training.shop.payments.ports.output;

import pl.training.shop.commons.Page;
import pl.training.shop.commons.ResultPage;
import pl.training.shop.payments.ports.model.Payment;
import pl.training.shop.payments.ports.model.PaymentStatus;

import java.util.Optional;

public interface PaymentRepository {

    Payment save(Payment payment);

    Optional<Payment> getById(String id);

    ResultPage<Payment> getByStatus(PaymentStatus status, Page page);

}
