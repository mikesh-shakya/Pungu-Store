package com.pungu.Pungu.Store.Services;

import com.pungu.Pungu.Store.Entities.Book;
import java.util.List;

public interface BookServices {

    public List<Book> getAllBooks();
    public Book addNewBook(Book book, Integer authorId, Integer genreId);
    public Book updateBook(Integer bookId, Book book);
    public String deleteBook(Integer bookId);
    public List<Book> getBookByAuthor(Integer authorId);
    public List<Book> getBookByGenre(Integer genreId);
}
