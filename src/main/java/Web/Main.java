package Web;


import Controller.BusinessRuleController;

import static spark.Spark.*;
/**
 * Created by Arthur on 13-1-2017.
 */
public class Main {
    public static void main(String[] args) {
        port(8181);

        post("/", (request, response) -> {
            String jsonObject = request.body();
            BusinessRuleController controller = new BusinessRuleController();
            controller.parseData(jsonObject);
            controller.createNewBusinessRule();
            controller.createRuleParts();
            controller.createDBLink(null);
            controller.generateDDL();
            return "ok ty";
        });
    }
}
