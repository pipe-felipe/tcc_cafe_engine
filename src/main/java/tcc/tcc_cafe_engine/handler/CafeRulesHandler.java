package tcc.tcc_cafe_engine.handler;

import tcc.tcc_cafe_engine.model.CustomerModel;
import tcc.tcc_cafe_engine.model.dto.CafeDTO;
import tcc.tcc_cafe_engine.rules.email.EmailRulesHandler;


public class CafeRulesHandler {

    public void cafeEngineHandler(CustomerModel customer) {
        var dto = new CafeDTO();

        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setDocument(customer.getDocument());
        dto.setCreditCard(customer.getCreditCard());
        dto.setAddress(customer.getAddress());
        dto.setAge(customer.getAge());
        dto.setTransactionValue(customer.getTransactionValue());

        dto.setTransactionStatus(EmailRulesHandler.reproveByEmail(customer).toString());
    }
}
