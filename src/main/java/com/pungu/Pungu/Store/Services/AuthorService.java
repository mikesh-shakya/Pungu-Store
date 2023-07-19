package com.pungu.Pungu.Store.Services;

import com.pungu.Pungu.Store.Entities.Author;

import java.util.List;

public interface AuthorService {

    public Author addAuthor(Author author);
    public List<Author> getAllAuthor();
    public Author updateAuthor(Integer authorId, Author author);
    public String deleteAuthor(Integer authorId);
}
