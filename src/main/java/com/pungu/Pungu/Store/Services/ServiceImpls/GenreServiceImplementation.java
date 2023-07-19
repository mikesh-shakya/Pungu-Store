package com.pungu.Pungu.Store.Services.ServiceImpls;

import com.pungu.Pungu.Store.Entities.Genre;
import com.pungu.Pungu.Store.Repositories.GenreRepository;
import com.pungu.Pungu.Store.Services.GenreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImplementation implements GenreServices {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Genre addGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public List<Genre> getAllGenre() {
        return genreRepository.findAll();
    }
}
