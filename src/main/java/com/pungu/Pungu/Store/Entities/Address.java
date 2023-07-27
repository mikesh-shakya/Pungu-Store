package com.pungu.Pungu.Store.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String receiverFirstname;
    private String receiverLastname;
    private String street;
    private String city;
    private String state;
    private String country;
    private int zipcode;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
