package ctapobep.modelling.security.oauth2;

import static io.qala.datagen.RandomShortApi.alphanumeric;

/**
 * Our app that will access the resources of the user from the {@link ResourceServer}.
 */
public class Client {
    public final String clientId = alphanumeric(10);
    public final String clientSecret = null;
    public final String redirectUri = "https://" + alphanumeric(10) + ".com";
    private final AuthServer authServer;
    private final ResourceServer resourceServer;

    public Client(AuthServer authServer, ResourceServer resourceServer) {
        this.authServer = authServer;
        this.resourceServer = resourceServer;
    }


}
