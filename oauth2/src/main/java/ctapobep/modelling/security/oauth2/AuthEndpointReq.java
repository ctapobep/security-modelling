package ctapobep.modelling.security.oauth2;

import io.qala.datagen.RandomShortApi;

import java.util.List;

public record AuthEndpointReq(String authEndpoint, ResponseType responseType, String clientId, String state,
                              Scopes scopes, String redirectUri) {

    public static AuthEndpointReq implicit(String authServerUrl, String clientId, Scopes scopes, String redirectUri) {
        String state = RandomShortApi.alphanumeric(10);
        return new AuthEndpointReq(authServerUrl, ResponseType.TOKEN, clientId, state, scopes, redirectUri);
    }

    public String toUrl() {
        List<String> requestParams = List.of("response_type="+responseType.urlAppearence,
                "client_id=" + clientId,
                "redirect_uri=" + redirectUri,
                "scope="+scopes,
                "state="+state);
        return this.authEndpoint + "?" + String.join("&", requestParams);
    }

    public enum Type {
        AUTHORIZATION_CODE(ResponseType.CODE), IMPLICIT(ResponseType.TOKEN);

        public final ResponseType authorizationEndpointResponseType;

        Type(ResponseType authorizationEndpointResponseType) {
            this.authorizationEndpointResponseType = authorizationEndpointResponseType;
        }
    }
    public enum ResponseType {
        CODE("code"), TOKEN("token");

        public final String urlAppearence;

        ResponseType(String urlAppearence) {
            this.urlAppearence = urlAppearence;
        }
    }
}
