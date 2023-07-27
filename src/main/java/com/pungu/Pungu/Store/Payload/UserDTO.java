package com.pungu.Pungu.Store.Payload;

import com.pungu.Pungu.Store.Entities.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class UserDTO {

    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private List<UserAddressList> addressList;
}
