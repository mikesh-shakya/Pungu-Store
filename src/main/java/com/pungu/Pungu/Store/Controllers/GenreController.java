package com.pungu.Pungu.Store.Controllers;

import com.pungu.Pungu.Store.Entities.Genre;
import com.pungu.Pungu.Store.Services.GenreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/genre")
public class GenreController {

    @Autowired
    private GenreServices genreServices;

    @GetMapping("/all")
    public ResponseEntity<List<Genre>> getAllGenres(){
        return ResponseEntity.ok(genreServices.getAllGenre());
    }

    @PostMapping("/add")
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre){
        return ResponseEntity.status(HttpStatus.CREATED).body(genreServices.addGenre(genre));
    }
}
