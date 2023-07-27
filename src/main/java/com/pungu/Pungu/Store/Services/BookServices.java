package com.pungu.Pungu.Store.Services;

import com.pungu.Pungu.Store.Entities.Book;
import com.pungu.Pungu.Store.Payload.BookDTO;

import java.util.List;

public interface BookServices {

    public List<BookDTO> getAllBooks();
    public BookDTO addNewBook(Book book, Integer authorId, Integer genreId);
    public BookDTO updateBook(Integer bookId, Book book);
    public String deleteBook(Integer bookId);
    public List<BookDTO> getBookByAuthor(Integer authorId);
    public List<BookDTO> getBookByGenre(Integer genreId);
}
