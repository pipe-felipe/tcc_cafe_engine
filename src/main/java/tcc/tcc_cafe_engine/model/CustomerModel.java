package tcc.tcc_cafe_engine.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CustomerModel {
    String name;
    String email;
    String document;
    CreditCard creditCard;
    Address address;
    Integer age;
    Double transactionValue;
}
