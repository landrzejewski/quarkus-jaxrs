package pl.training.shop.payments.ports.input;

import pl.training.shop.commons.Page;
import pl.training.shop.commons.ResultPage;
import pl.training.shop.payments.ports.model.Payment;
import pl.training.shop.payments.ports.model.PaymentRequest;
import pl.training.shop.payments.ports.model.PaymentStatus;

public interface PaymentService {

    Payment process(PaymentRequest paymentRequest);

    Payment getById(String id);

    ResultPage<Payment> getByStatus(PaymentStatus status, Page page);

}
