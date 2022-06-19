package pl.training.shop.payments.adapters.persistence;

import pl.training.shop.commons.Page;
import pl.training.shop.commons.ResultPage;
import pl.training.shop.payments.ports.model.Payment;
import pl.training.shop.payments.ports.model.PaymentStatus;
import pl.training.shop.payments.ports.output.PaymentRepository;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Singleton
public class InMemoryPaymentRepository implements PaymentRepository {

    private final Map<String, Payment> payments = new HashMap<>();

    @Override
    public synchronized Payment save(Payment payment) {
        payments.put(payment.getId(), payment);
        return payment;
    }

    @Override
    public synchronized Optional<Payment> getById(String id) {
        return Optional.ofNullable(payments.get(id));
    }

    @Override
    public synchronized ResultPage<Payment> getByStatus(PaymentStatus status, Page page) {
        var results = payments.values().stream()
                .filter(payment -> payment.getStatus() == status)
                .toList();
        return new ResultPage<>(results, 0, - 1);
    }

}
