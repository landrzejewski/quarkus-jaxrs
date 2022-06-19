package pl.training.shop.payments.ports;

import pl.training.shop.payments.ports.input.PaymentService;
import pl.training.shop.payments.ports.output.IdGenerator;
import pl.training.shop.payments.ports.output.PaymentRepository;

public interface PaymentFactory {

    PaymentService paymentsService(IdGenerator idGenerator, PaymentRepository paymentRepository);

}
