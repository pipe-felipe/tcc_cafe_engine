package tcc.tcc_cafe_engine.rules.email;

import lombok.ToString;
import tcc.tcc_cafe_engine.model.CustomerModel;
import tcc.tcc_cafe_engine.rules.Rules;

import java.util.Objects;

@ToString
public class EmailRulesHandler implements Rules {
    public static TransactionStaus reproveByEmail(CustomerModel c) {
        if (Objects.equals("c.getEmail()", "ledrao@gmail.com")) {
            return TransactionStaus.REPROVE;
        } else {
            return TransactionStaus.APPROVE;
        }
    }
}
