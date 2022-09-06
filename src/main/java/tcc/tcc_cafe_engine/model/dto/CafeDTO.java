package tcc.tcc_cafe_engine.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tcc.tcc_cafe_engine.model.Address;
import tcc.tcc_cafe_engine.model.CreditCard;

@Getter
@Setter
@ToString
public class CafeDTO {
    String name;
    String email;
    String document;
    CreditCard creditCard;
    Address address;
    Integer age;
    Double transactionValue;
    String transactionStatus;
}
