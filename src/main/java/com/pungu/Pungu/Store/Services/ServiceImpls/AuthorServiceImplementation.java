package com.pungu.Pungu.Store.Services.ServiceImpls;

import com.pungu.Pungu.Store.CustomException.ResourceNotFoundException;
import com.pungu.Pungu.Store.Entities.Author;
import com.pungu.Pungu.Store.Entities.Book;
import com.pungu.Pungu.Store.Payload.AuthorBookList;
import com.pungu.Pungu.Store.Payload.AuthorDTO;
import com.pungu.Pungu.Store.Repositories.AuthorRepository;
import com.pungu.Pungu.Store.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImplementation implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<AuthorDTO> getAllAuthor() {
        List<Author> list = authorRepository.findAll();
        return list.stream().map(this::convertAuthorIntoDto).collect(Collectors.toList());
    }

    @Override
    public AuthorDTO getAuthorById(Integer authorId) {
        Author foundAuthor = authorRepository.findById(authorId).orElseThrow(()-> new ResourceNotFoundException("No such author presents."));
        return convertAuthorIntoDto(foundAuthor);
    }

    @Override
    public AuthorDTO updateAuthor(Integer authorId, Author author) {
        Author foundAuthor = authorRepository.findById(authorId).orElseThrow(()-> new ResourceNotFoundException("No such author presents."));
        foundAuthor.setFirstname(author.getFirstname());
        foundAuthor.setLastname(author.getLastname());
        foundAuthor.setCityOfBirth(author.getCityOfBirth());
        foundAuthor.setDescription(author.getDescription());

        authorRepository.save(foundAuthor);
        return convertAuthorIntoDto(foundAuthor);
    }

    @Override
    public String deleteAuthor(Integer authorId) {
        Author foundAuthor = authorRepository.findById(authorId).orElseThrow(()-> new ResourceNotFoundException("No such author presents."));
        authorRepository.delete(foundAuthor);
        return "Author deleted successfully.";
    }

    public AuthorDTO convertAuthorIntoDto(Author author){
        AuthorDTO authorDTO = new AuthorDTO();

        authorDTO.setId(author.getId());
        authorDTO.setFirstname(author.getFirstname());
        authorDTO.setLastname(author.getLastname());
        authorDTO.setDateOfBirth(author.getDateOfBirth());
        authorDTO.setCityOfBirth(author.getCityOfBirth());
        authorDTO.setDescription(author.getDescription());

        List<Book> list = author.getListOfBooks();
        List<AuthorBookList> authorBookLists = new ArrayList<>();
        for(Book b: list){
            AuthorBookList authorBook = new AuthorBookList();
            authorBook.setName(b.getName());
            authorBook.setGenre(b.getGenre().getName());
            authorBookLists.add(authorBook);
        }
        authorDTO.setListOfBooks(authorBookLists);

        return authorDTO;
    }
}
