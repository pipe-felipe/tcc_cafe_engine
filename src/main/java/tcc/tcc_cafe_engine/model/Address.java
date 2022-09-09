package tcc.tcc_cafe_engine.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Address {
    String street;
    Integer number;
    String city;
    String state;
    String country;
    String zipCode;
}
