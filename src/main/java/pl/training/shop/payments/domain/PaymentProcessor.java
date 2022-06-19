package pl.training.shop.payments.domain;

import lombok.RequiredArgsConstructor;
import pl.training.shop.commons.Page;
import pl.training.shop.commons.ResultPage;
import pl.training.shop.payments.ports.input.PaymentService;
import pl.training.shop.payments.ports.model.Payment;
import pl.training.shop.payments.ports.model.PaymentNotFoundException;
import pl.training.shop.payments.ports.model.PaymentRequest;
import pl.training.shop.payments.ports.model.PaymentStatus;
import pl.training.shop.payments.ports.output.IdGenerator;
import pl.training.shop.payments.ports.output.PaymentRepository;

@RequiredArgsConstructor
class PaymentProcessor implements PaymentService {

    private static final PaymentStatus DEFAULT_PAYMENT_STATUS = PaymentStatus.STARTED;

    private final IdGenerator idGenerator;
    private final PaymentFeeCalculator paymentFeeCalculator;
    private final TimeProvider timeProvider;
    private final PaymentRepository paymentRepository;

    @Override
    public Payment process(PaymentRequest paymentRequest) {
        var paymentFee = paymentFeeCalculator.calculate(paymentRequest.getValue());
        var payment = Payment.builder()
                .id(idGenerator.getNext())
                .value(paymentRequest.getValue().add(paymentFee))
                .timestamp(timeProvider.getTimestamp())
                .status(DEFAULT_PAYMENT_STATUS)
                .build();
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getById(String id) {
        return paymentRepository.getById(id)
                .orElseThrow(PaymentNotFoundException::new);
    }

    @Override
    public ResultPage<Payment> getByStatus(PaymentStatus status, Page page) {
        return paymentRepository.getByStatus(status, page);
    }

}
