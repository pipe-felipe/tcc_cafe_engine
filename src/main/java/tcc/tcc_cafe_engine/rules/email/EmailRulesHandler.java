package tcc.tcc_cafe_engine.rules.email;

import lombok.ToString;
import tcc.tcc_cafe_engine.model.CustomerModel;
import tcc.tcc_cafe_engine.rules.TransactionStatus;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@ToString
public class EmailRulesHandler {

    public static Map<String, String> reproveByEmail(CustomerModel c) {
        if (Objects.equals(c.getEmail(), "ledrao@gmail.com")) {
            Map<String , String> result = new HashMap<>();
            result.put("transactionStatus", TransactionStatus.REPROVE.toString());
            var x =  TransactionStatus.MESSAGE.toString() = "";
            result.put("Message", );
        } else {

        }
    }
}
