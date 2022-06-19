package pl.training.shop.payments.adapters.rest;

import lombok.RequiredArgsConstructor;
import pl.training.shop.payments.ports.input.PaymentService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("payments")
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class PaymentController {

    private final PaymentService paymentService;
    private final RestPaymentMapper mapper;

    @POST
    public Response process(PaymentRequestDto paymentRequestDto, @Context UriInfo uriInfo) {
        var paymentRequest = mapper.toDomain(paymentRequestDto);
        var payment = paymentService.process(paymentRequest);
        var paymentDto = mapper.toDto(payment);
        var locationUri = uriInfo.getAbsolutePathBuilder().path(payment.getId()).build();
        return Response.created(locationUri)
                .entity(paymentDto)
                .build();
    }

}
