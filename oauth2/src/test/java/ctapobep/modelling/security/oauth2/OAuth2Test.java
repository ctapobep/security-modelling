package ctapobep.modelling.security.oauth2;

import org.junit.Test;

public class OAuth2Test {

    @Test
    public void implicitFlow() {
        System.out.println("*** Demonstrating Implicit Flow ***");
        AuthServer authServer = authServer();
        Client client = new Client(authServer, resourceServer());
        AuthEndpointReq authEndpointReq = AuthEndpointReq.implicit(
                authServer.getAuthEndpoint(), client.clientId, Scopes.random(), client.redirectUri
        );
        new Browser().open(authEndpointReq.toUrl());
    }



    private static AuthServer authServer() {
        return new AuthServer();
    }
    private static ResourceServer resourceServer() {
        return new ResourceServer();
    }
}