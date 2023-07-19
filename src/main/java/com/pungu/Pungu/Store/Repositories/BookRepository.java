package com.pungu.Pungu.Store.Repositories;

import com.pungu.Pungu.Store.Entities.Author;
import com.pungu.Pungu.Store.Entities.Book;
import com.pungu.Pungu.Store.Entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByAuthor(Author author);
    List<Book> findByGenre(Genre genre);
}
