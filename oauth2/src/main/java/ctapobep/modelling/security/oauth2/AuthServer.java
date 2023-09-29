package ctapobep.modelling.security.oauth2;

import static io.qala.datagen.RandomShortApi.alphanumeric;

public class AuthServer {
    private final String baseUrl = "https://authserv." + alphanumeric(10) + ".com";

    public String getAuthEndpoint() {
        return baseUrl + "/auth";
    }
}
