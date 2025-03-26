package org.andrekreou.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.andrekreou.dto.request.CreateProductRequest;
import org.andrekreou.dto.response.CreateProductResponse;
import org.andrekreou.dto.response.ErrorResponse;
import org.andrekreou.dto.request.RetrieveTransactionRequest;
import org.andrekreou.dto.response.BalanceTransactionResponse;
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
     * @param retrieveTransactionRequest the object that contains the transaction ID
     * @return a response that contains the transaction information provided by Stripe
     */
    @Operation(summary = "Responsible to retrieve the transaction information provided by Stripe")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Successfully retrieved the order information",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = BalanceTransactionResponse.class))}),
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
    @RolesAllowed("admin")
    public Response retrieve(@BeanParam @Valid RetrieveTransactionRequest retrieveTransactionRequest) {
        BalanceTransactionResponse response = service.retrieveTransaction(retrieveTransactionRequest);
        return Response.ok(response).build();
    }

    /**
     * Receives a product name and description, in order to create a new product to be
     * purchased from customers via {@link StripeClient}
     *
     * @param createProductRequest the object that contains the product name and description
     * @return a response that contains the product creation information provided by Stripe
     */
    @Operation(summary = "Responsible to create a product through Stripe")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Successfully created the product",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = CreateProductResponse.class))}),
            @APIResponse(responseCode = "400", description = "Missing mandatory fields.",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = ErrorResponse.class))),
            @APIResponse(responseCode = "500", description = "Unknown error occurred",
                    content = @Content)})
    @Path("/product")
    @POST
    @RolesAllowed("trainer")
    public Response createProduct(@RequestBody @Valid CreateProductRequest createProductRequest) {
        CreateProductResponse response = service.createProduct(createProductRequest);
        return Response.ok(response).build();
    }
}
