package org.andrekreou.resource;

import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.oidc.UserInfo;
import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.andrekreou.entity.User;

@IfBuildProfile("test")
@Path("/stripe")
public class AuthenticationResource {

    @Inject
    UserInfo userInfo;

    /**
     * Initiates the authentication procedures for a {@link User} regardless of the role.
     * <p>
     * This endpoint simulates a user that tries to access the secured backend endpoints,
     * and it is only used by end-to-end tests. It triggers the OAuth2 authorization code
     * flow with Proof of Key Code Exchange (PKCE). A successful authentication means that
     * an access token has been generated and the corresponding backend endpoint can now
     * be called.
     * </p>
     *
     * @return a {@link Response} that informs about a successful authentication.
     */
    @Path("/login")
    @GET
    @Authenticated
    @Produces(MediaType.APPLICATION_JSON)
    public Response login() {
        User user = User.create(userInfo);
        return Response.ok(user).build();
    }
}
