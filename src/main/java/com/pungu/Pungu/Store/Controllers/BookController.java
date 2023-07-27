package com.pungu.Pungu.Store.Controllers;

import com.pungu.Pungu.Store.Entities.Book;
import com.pungu.Pungu.Store.Payload.BookDTO;
import com.pungu.Pungu.Store.Services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private BookServices bookServices;


    @GetMapping("/all")
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        List<BookDTO> allBooks = bookServices.getAllBooks();
        return ResponseEntity.ok(allBooks);
    }

    @PostMapping("/add/author/{authorId}/genre/{genreId}")
    public ResponseEntity<BookDTO> addNewBook(@RequestBody Book book, @PathVariable Integer authorId, @PathVariable Integer genreId){
        BookDTO book_added = bookServices.addNewBook(book, authorId, genreId);
        return ResponseEntity.status(HttpStatus.CREATED).body(book_added);
    }

    @GetMapping("/all/author/{authorId}")
    public ResponseEntity<List<BookDTO>> getByAuthor(@PathVariable Integer authorId){
        List<BookDTO> bookByAuthor = bookServices.getBookByAuthor(authorId);
        return ResponseEntity.ok(bookByAuthor);
    }

    @GetMapping("/all/genre/{genreId}")
    public ResponseEntity<List<BookDTO>> getByGenre(@PathVariable Integer genreId){
        List<BookDTO> bookByGenre = bookServices.getBookByGenre(genreId);
        return ResponseEntity.ok(bookByGenre);
    }

    @PutMapping("/update/{bookId}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Integer bookId, @RequestBody Book book){
        return ResponseEntity.ok(bookServices.updateBook(bookId, book));
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer bookId){
        return ResponseEntity.status(HttpStatus.OK).body(bookServices.deleteBook(bookId));
    }
}
