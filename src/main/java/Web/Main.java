package Web;


import Controller.BusinessRuleController;

import static spark.Spark.*;
/**
 * Created by Arthur on 13-1-2017.
 */
public class Main {
    static BusinessRuleController controller;
    public static void main(String[] args) {
        controller = new BusinessRuleController();
        port(8181);

        get("/apply/:businessruleid", (request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            if (!request.params(":businessruleid").isEmpty()) {
                try {
                    int businessRuleId = Integer.parseInt(request.params(":businessruleid"));
                    controller.applyBusinessRule(businessRuleId);
                    return "OK";
                } catch (Exception e) {
                    return "Invalid ID";
                }
            } else {
                return "No ID specified";
            }
        });

        get("/enable/:businessruleid", (request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            if (!request.params(":businessruleid").isEmpty()) {
                try {
                    int businessRuleId = Integer.parseInt(request.params(":businessruleid"));
                    controller.enableBusinessRule(businessRuleId);
                    return "OK";
                } catch (Exception e) {
                    return "Invalid ID";
                }
            } else {
                return "No ID specified";
            }
            //return "Hello: " + request.params(":businessruleid");
        });

        get("/disable/:businessruleid", (request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            if (!request.params(":businessruleid").isEmpty()) {
                try {
                    int businessRuleId = Integer.parseInt(request.params(":businessruleid"));
                    controller.disableBusinessRule(businessRuleId);
                    return "OK";
                } catch (Exception e) {
                    return "Invalid ID";
                }
            } else {
                return "No ID specified";
            }
        });

        get("/drop/:businessruleid", (request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            if (!request.params(":businessruleid").isEmpty()) {
                try {
                    int businessRuleId = Integer.parseInt(request.params(":businessruleid"));
                    controller.dropBusinessRule(businessRuleId);
                    return "OK";
                } catch (Exception e) {
                    return "Invalid ID";
                }
            } else {
                return "No ID specified";
            }
        });
    }
}
