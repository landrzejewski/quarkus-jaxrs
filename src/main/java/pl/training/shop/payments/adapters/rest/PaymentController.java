package pl.training.shop.payments.adapters.rest;

import lombok.RequiredArgsConstructor;
import pl.training.shop.commons.Page;
import pl.training.shop.payments.ports.input.PaymentService;
import pl.training.shop.payments.ports.model.PaymentStatus;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import static pl.training.shop.payments.ports.model.PaymentStatus.STARTED;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("payments")
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class PaymentController {

    private final PaymentService paymentService;
    private final RestPaymentMapper mapper;

    @POST
    public Response process(@Valid PaymentRequestDto paymentRequestDto, @Context UriInfo uriInfo) {
        var paymentRequest = mapper.toDomain(paymentRequestDto);
        var payment = paymentService.process(paymentRequest);
        var paymentDto = mapper.toDto(payment);
        var locationUri = uriInfo.getAbsolutePathBuilder().path(payment.getId()).build();
        return Response.created(locationUri)
                .entity(paymentDto)
                .build();
    }

    @GET
    @Path("{id:\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12}}")
    public Response getById(@PathParam("id") String id) {
        var payment = paymentService.getById(id);
        var paymentDto = mapper.toDto(payment);
        return Response.ok(paymentDto).build();
    }

    @GET
    @Path("started")
    public Response getStartedPayments(
            @QueryParam("pageSize") @DefaultValue("5") int pageSize,
            @QueryParam("pagNumberSize") @DefaultValue("0") int pageNumber) {
        var resultPage = paymentService.getByStatus(STARTED, new Page(pageNumber, pageSize));
        var resultPageDto = mapper.toDto(resultPage);
        return Response.ok(resultPageDto).build();
    }

}
