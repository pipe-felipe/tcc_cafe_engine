package tcc.tcc_cafe_engine.model;

import lombok.Value;

@Value
public class Address {
    String street;
    Integer number;
    String city;
    String state;
    String country;
    String zipCode;
}
