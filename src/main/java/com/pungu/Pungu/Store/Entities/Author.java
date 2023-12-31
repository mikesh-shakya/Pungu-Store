package com.pungu.Pungu.Store.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String firstname;
    private String lastname;
    private String DateOfBirth;
    private String cityOfBirth;
    private String description;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> listOfBooks;
}
