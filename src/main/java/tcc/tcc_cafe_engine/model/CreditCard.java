package tcc.tcc_cafe_engine.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CreditCard {
    String flag;
    String holderName;
    String number;
    String validThru;
    String cvv;
}
