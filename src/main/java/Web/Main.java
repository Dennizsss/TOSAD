package Web;
import java.util.Map;
import java.util.Set;

import static spark.Spark.*;
/**
 * Created by Arthur on 13-1-2017.
 */
public class Main {
    public static void main(String[] args) {
        port(8080);

        get("/", (request, response) -> {
            return "This is not how it works.";
        });

        post("/", (request, response) -> {
            String jsonObject = request.body();

            return jsonObject;
        });
    }
}
