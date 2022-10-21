package tcc.tcc_cafe_engine.rules.email;

import lombok.ToString;
import tcc.tcc_cafe_engine.model.CustomerModel;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@ToString
public class EmailRulesDefinition {

    public static Map<String, String> randomRuleForTest(CustomerModel customer) {

        Map<String, String> result = new HashMap<>();

        if (Objects.equals(customer.getEmail(), "ladrao@gmail.com")) {
            result.put("status", "REPROVE");
            result.put("message", "Reproved by email");
        } else if (customer.getName().contains("Furtado")) {
            result.put("status", "REPROVE");
            result.put("message", "Second name 'Furtado' is not allowed");
        }
        else {
            result.put("status", "APPROVE");
            result.put("message", null);
        }
        return result;
    }
}
