package com.pungu.Pungu.Store.Services.ServiceImpls;

import com.pungu.Pungu.Store.CustomException.ResourceNotFoundException;
import com.pungu.Pungu.Store.Entities.Author;
import com.pungu.Pungu.Store.Entities.Book;
import com.pungu.Pungu.Store.Entities.Genre;
import com.pungu.Pungu.Store.Payload.BookDTO;
import com.pungu.Pungu.Store.Repositories.AuthorRepository;
import com.pungu.Pungu.Store.Repositories.BookRepository;
import com.pungu.Pungu.Store.Repositories.GenreRepository;
import com.pungu.Pungu.Store.Services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServicesImplementation implements BookServices {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream().map(this::convertBookIntoDTO).collect(Collectors.toList());
    }

    @Override
    public BookDTO addNewBook(Book book, Integer authorId, Integer genreId) {
        Author found_author = authorRepository.findById(authorId).orElseThrow(()-> new ResourceNotFoundException("No such author presents."));
        Genre found_genre = genreRepository.findById(genreId).orElseThrow(()-> new ResourceNotFoundException("No such genre presents."));
        book.setAuthor(found_author);
        book.setGenre(found_genre);
        // implementing logic for calculating discount percentage
        int discount_percent = (int) (( (book.getActual_price() - book.getDiscounted_price())/book.getActual_price()) * 100);
        book.setOff_percentage(discount_percent);

        return convertBookIntoDTO(bookRepository.save(book));
    }

    @Override
    public BookDTO updateBook(Integer bookId, Book book) {
        Book foundBook = bookRepository.findById(bookId).orElseThrow(()-> new ResourceNotFoundException("No such book exist with given id: " + bookId));
        foundBook.setName(book.getName());
        foundBook.setActual_price(book.getActual_price());
        foundBook.setDiscounted_price(book.getDiscounted_price());
        // implementing logic for calculating discount percentage
        int discount_percent = (int) (( (book.getActual_price() - book.getDiscounted_price())/book.getActual_price()) * 100);
        foundBook.setOff_percentage(discount_percent);
        bookRepository.save(foundBook);
        return convertBookIntoDTO(foundBook);
    }

    @Override
    public String deleteBook(Integer bookId) {
        Book foundBook = bookRepository.findById(bookId).orElseThrow(()-> new ResourceNotFoundException("No such book exist with given id: " + bookId));
        bookRepository.deleteById(bookId);
        return "The book with book id: " + bookId + " has been deleted successfully.";
    }

    @Override
    public List<BookDTO> getBookByAuthor(Integer authorId) {
        Author found_author = authorRepository.findById(authorId).orElseThrow(()-> new ResourceNotFoundException("No such author presents."));

        return bookRepository.findByAuthor(found_author).stream().map(this::convertBookIntoDTO).collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> getBookByGenre(Integer genreId) {
        Genre found_genre = genreRepository.findById(genreId).orElseThrow(()-> new ResourceNotFoundException("No such genre presents."));
        return bookRepository.findByGenre(found_genre).stream().map(this::convertBookIntoDTO).collect(Collectors.toList());
    }


    public BookDTO convertBookIntoDTO(Book b){
        // converting book into bookDto
        BookDTO bookDTO = new BookDTO();

        bookDTO.setId(b.getId());
        bookDTO.setName(b.getName());
        bookDTO.setGenre(b.getGenre().getName());
        bookDTO.setAuthor(b.getAuthor().getFirstname() + " " + b.getAuthor().getLastname());
        bookDTO.setActual_price(b.getActual_price());
        bookDTO.setDiscounted_price(b.getDiscounted_price());
        bookDTO.setOff_percentage(b.getOff_percentage());

        return bookDTO;
    }
}
