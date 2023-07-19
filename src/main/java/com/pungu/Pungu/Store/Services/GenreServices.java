package com.pungu.Pungu.Store.Services;

import com.pungu.Pungu.Store.Entities.Genre;

import java.util.List;

public interface GenreServices {

    public Genre addGenre(Genre genre);
    public List<Genre> getAllGenre();
}
