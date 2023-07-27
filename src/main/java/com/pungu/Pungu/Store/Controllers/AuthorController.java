package com.pungu.Pungu.Store.Controllers;

import com.pungu.Pungu.Store.Entities.Author;
import com.pungu.Pungu.Store.Payload.AuthorDTO;
import com.pungu.Pungu.Store.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/all")
    public ResponseEntity<List<AuthorDTO>> getAllBooks(){
        List<AuthorDTO> allAuthor = authorService.getAllAuthor();
        return ResponseEntity.ok(allAuthor);
    }

    @PostMapping("/add")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author){
        Author author_added = authorService.addAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(author_added);
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Integer authorId){
        return ResponseEntity.ok(authorService.getAuthorById(authorId));
    }

    @PutMapping("/update/{authorId}")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable Integer authorId, @RequestBody Author author){
        return ResponseEntity.ok(authorService.updateAuthor(authorId, author));
    }

    @DeleteMapping("/delete/{authorId}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Integer authorId) {
        return ResponseEntity.ok(authorService.deleteAuthor(authorId));
    }
}
