package Web;
import static spark.Spark.*;
/**
 * Created by Arthur on 13-1-2017.
 */
public class Main {
    public static void main(String[] args) {
        get("/hello", (request, response) -> "Hello World!");
    }
}
