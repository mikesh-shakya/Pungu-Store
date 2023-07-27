package com.pungu.Pungu.Store.Services;

import com.pungu.Pungu.Store.Entities.Author;
import com.pungu.Pungu.Store.Payload.AuthorDTO;

import java.util.List;

public interface AuthorService {

    public Author addAuthor(Author author);
    public List<AuthorDTO> getAllAuthor();
    public AuthorDTO getAuthorById(Integer authorId);
    public AuthorDTO updateAuthor(Integer authorId, Author author);
    public String deleteAuthor(Integer authorId);
}
