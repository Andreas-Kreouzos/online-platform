package org.andrekreou.resource;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.andrekreou.dto.ErrorResponse;
import org.andrekreou.dto.RetrieveTransaction;
import org.andrekreou.response.BalanceTransaction;
import org.andrekreou.service.IStripeService;
import org.andrekreou.client.StripeClient;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("/stripe")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StripeResource {

    @Inject
    IStripeService service;

    /**
     * Receives the transaction ID, in order to retrieve the related balance transaction
     * details via {@link StripeClient}
     *
     * @param retrieveTransaction the object that contains the transaction ID
     * @return a response that contains the transaction information provided by Stripe
     */
    @Operation(summary = "Responsible to retrieve the transaction information provided by Stripe")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Successfully retrieved the order information",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = BalanceTransaction.class))}),
            @APIResponse(responseCode = "400", description = "Transaction ID is mandatory.",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = ErrorResponse.class))),
            @APIResponse(responseCode = "404", description = "Transaction not found",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = ErrorResponse.class))),
            @APIResponse(responseCode = "500", description = "Unknown error occurred",
                    content = @Content)})
    @Path("/transaction")
    @GET
    public Response retrieve(@RequestBody @Valid RetrieveTransaction retrieveTransaction) {
        BalanceTransaction balanceTransaction = service.retrieveTransaction(retrieveTransaction);
        return Response.ok(balanceTransaction).build();
    }

}
