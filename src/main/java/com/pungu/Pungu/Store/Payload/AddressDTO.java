package com.pungu.Pungu.Store.Payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AddressDTO {

    private int id;
    private String receiverFirstname;
    private String receiverLastname;
    private String street;
    private String city;
    private String state;
    private String country;
    private int zipcode;
    private int userId;
    private String userName;
}
