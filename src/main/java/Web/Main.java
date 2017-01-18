package Web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


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

            JSONParser parser = new JSONParser();
            try {
                Object obj = parser.parse(jsonObject);
                JSONObject object = (JSONObject) obj;
                JSONArray ruleparts = (JSONArray) object.get("ruleparts");
                for (Object rulepart: ruleparts) {
                    System.out.println(rulepart.toString());
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            //System.out.println(array.get(1));

            return jsonObject;
        });
    }
}
