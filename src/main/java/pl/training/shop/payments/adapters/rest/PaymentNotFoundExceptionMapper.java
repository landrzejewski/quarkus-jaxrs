package pl.training.shop.payments.adapters.rest;

import pl.training.shop.commons.rest.ExceptionDto;
import pl.training.shop.payments.ports.model.PaymentNotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PaymentNotFoundExceptionMapper implements ExceptionMapper<PaymentNotFoundException> {

    @Override
    public Response toResponse(PaymentNotFoundException e) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new ExceptionDto("Payment not found"))
                .build();
    }

}
