package tcc.tcc_cafe_engine.model;

import lombok.Value;

@Value
public class CreditCard {
    String flag;
    String holderName;
    String number;
    String validThru;
    String cvv;
}
