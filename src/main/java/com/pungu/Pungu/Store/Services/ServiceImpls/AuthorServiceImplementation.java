package com.pungu.Pungu.Store.Services.ServiceImpls;

import com.pungu.Pungu.Store.CustomException.ResourceNotFoundException;
import com.pungu.Pungu.Store.Entities.Author;
import com.pungu.Pungu.Store.Repositories.AuthorRepository;
import com.pungu.Pungu.Store.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorServiceImplementation implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public Author updateAuthor(Integer authorId, Author author) {
        Author foundAuthor = authorRepository.findById(authorId).orElseThrow(()-> new ResourceNotFoundException("No such author presents."));
        foundAuthor.setFirstname(author.getFirstname());
        foundAuthor.setLastname(author.getLastname());
        foundAuthor.setAge(author.getAge());
        foundAuthor.setCityOfBirth(author.getCityOfBirth());
        foundAuthor.setDescription(author.getDescription());

        authorRepository.save(foundAuthor);
        return foundAuthor;
    }

    @Override
    public String deleteAuthor(Integer authorId) {
        Author foundAuthor = authorRepository.findById(authorId).orElseThrow(()-> new ResourceNotFoundException("No such author presents."));
        authorRepository.delete(foundAuthor);
        return "Author deleted successfully.";
    }
}
