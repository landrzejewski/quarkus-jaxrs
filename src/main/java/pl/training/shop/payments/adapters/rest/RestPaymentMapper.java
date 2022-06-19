package pl.training.shop.payments.adapters.rest;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.training.shop.commons.FastMoneyMapper;
import pl.training.shop.commons.ResultPage;
import pl.training.shop.commons.rest.ResultPageDto;
import pl.training.shop.payments.ports.model.Payment;
import pl.training.shop.payments.ports.model.PaymentRequest;

import java.util.List;

@Mapper(componentModel = "cdi", uses = FastMoneyMapper.class)
public interface RestPaymentMapper {

    @Mapping(source = "requestId", target = "id")
    PaymentRequest toDomain(PaymentRequestDto paymentRequestDto);

    PaymentDto toDto(Payment payment);

    @IterableMapping(elementTargetType = PaymentDto.class)
    List<PaymentDto> toDto(List<Payment> payments);

    ResultPageDto<PaymentDto> toDto(ResultPage<Payment> resultPage);

}
