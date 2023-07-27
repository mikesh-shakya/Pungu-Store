package com.pungu.Pungu.Store.Payload;

import com.pungu.Pungu.Store.Entities.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class AuthorDTO {
    private int id;
    private String firstname;
    private String lastname;
    private String DateOfBirth;
    private String cityOfBirth;
    private String description;
    private List<AuthorBookList> listOfBooks;
}
