package pl.training.shop.payments.domain;

import org.javamoney.moneta.FastMoney;
import pl.training.shop.payments.ports.output.IdGenerator;
import pl.training.shop.payments.ports.PaymentFactory;
import pl.training.shop.payments.ports.output.PaymentRepository;
import pl.training.shop.payments.ports.input.PaymentService;

public class DefaultPaymentFactory implements PaymentFactory {

    private static final PaymentFeeCalculator PAYMENT_FEE_CALCULATOR = new ConstantPaymentFeeCalculator(FastMoney.of(10, "PLN"));
    private static final TimeProvider TIME_PROVIDER = new SystemTimeProvider();

    @Override
    public PaymentService paymentsService(IdGenerator idGenerator, PaymentRepository paymentRepository) {
        return new PaymentProcessor(idGenerator, PAYMENT_FEE_CALCULATOR, TIME_PROVIDER, paymentRepository);
    }

}
