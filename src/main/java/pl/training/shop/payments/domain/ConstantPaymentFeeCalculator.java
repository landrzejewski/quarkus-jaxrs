package pl.training.shop.payments.domain;

import lombok.Value;
import org.javamoney.moneta.FastMoney;

@Value
class ConstantPaymentFeeCalculator implements PaymentFeeCalculator {

    FastMoney fee;

    @Override
    public FastMoney calculate(FastMoney value) {
        return fee;
    }

}
