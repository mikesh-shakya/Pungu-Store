package com.pungu.Pungu.Store.Services.ServiceImpls;

import com.pungu.Pungu.Store.CustomException.ResourceNotFoundException;
import com.pungu.Pungu.Store.Entities.Author;
import com.pungu.Pungu.Store.Entities.Book;
import com.pungu.Pungu.Store.Entities.Genre;
import com.pungu.Pungu.Store.Repositories.AuthorRepository;
import com.pungu.Pungu.Store.Repositories.BookRepository;
import com.pungu.Pungu.Store.Repositories.GenreRepository;
import com.pungu.Pungu.Store.Services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServicesImplementation implements BookServices {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book addNewBook(Book book, Integer authorId, Integer genreId) {
        Author found_author = authorRepository.findById(authorId).orElseThrow(()-> new ResourceNotFoundException("No such author presents."));
        Genre found_genre = genreRepository.findById(genreId).orElseThrow(()-> new ResourceNotFoundException("No such genre presents."));
        book.setAuthor(found_author);
        book.setGenre(found_genre);

        int discount_percent = (int) (( (book.getActual_price() - book.getDiscounted_price())/book.getActual_price()) * 100);
        book.setOff_percentage(discount_percent);
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Integer bookId, Book book) {
        Book foundBook = bookRepository.findById(bookId).orElseThrow(()-> new ResourceNotFoundException("No such book exist with given id: " + bookId));

        foundBook.setName(book.getName());
        foundBook.setAuthor(book.getAuthor());
        foundBook.setGenre(book.getGenre());
        bookRepository.save(foundBook);
        return foundBook;
    }

    @Override
    public String deleteBook(Integer bookId) {
        Book foundBook = bookRepository.findById(bookId).orElseThrow(()-> new ResourceNotFoundException("No such book exist with given id: " + bookId));
        bookRepository.deleteById(bookId);
        return "The book with book id: " + bookId + " has been deleted successfully.";
    }

    @Override
    public List<Book> getBookByAuthor(Integer authorId) {
        Author found_author = authorRepository.findById(authorId).orElseThrow(()-> new ResourceNotFoundException("No such author presents."));
        return bookRepository.findByAuthor(found_author);
    }

    @Override
    public List<Book> getBookByGenre(Integer genreId) {
        Genre found_genre = genreRepository.findById(genreId).orElseThrow(()-> new ResourceNotFoundException("No such genre presents."));
        return bookRepository.findByGenre(found_genre);
    }
}
