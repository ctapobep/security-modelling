package ctapobep.modelling.security.oauth2;

import java.util.ArrayList;
import java.util.List;

import static io.qala.datagen.RandomShortApi.sample;

public class Scopes {
    private final List<String> scopes;

    public Scopes(String ... scopes) {
        this.scopes = List.of(scopes);
    }

    public static Scopes random() {
        return sample(new Scopes("create"), new Scopes("create_video", "comment"));
    }

    @Override
    public String toString() {
        return String.join("+", scopes);
    }
}
