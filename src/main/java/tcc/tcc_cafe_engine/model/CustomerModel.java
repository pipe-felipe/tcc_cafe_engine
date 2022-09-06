package tcc.tcc_cafe_engine.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CustomerModel {
    String name;
    String email;
    String document;
    CreditCard creditCard;
    Address address;
    Integer age;
    Double transactionValue;
}
