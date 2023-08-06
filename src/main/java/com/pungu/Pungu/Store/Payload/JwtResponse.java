package com.pungu.Pungu.Store.Payload;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtResponse {

    private String username;
    private String token;
}
