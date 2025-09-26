package io.github.Guimaraes131.library.service;

import io.github.Guimaraes131.library.controller.dto.PostAuthorDTO;
import io.github.Guimaraes131.library.model.Author;
import io.github.Guimaraes131.library.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public Author create(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> index() {
        return authorRepository.findAll();
    }
}
