package io.github.Guimaraes131.library.service;

import io.github.Guimaraes131.library.controller.dto.PostBookDTO;
import io.github.Guimaraes131.library.model.Author;
import io.github.Guimaraes131.library.model.Book;
import io.github.Guimaraes131.library.repository.AuthorRepository;
import io.github.Guimaraes131.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public Book create(PostBookDTO dto) {

        Author author = authorService.findById(dto.authorId());

        Book book = Book.builder()
                .title(dto.title())
                .description(dto.description())
                .publicationDate(dto.publicationDate())
                .genre(dto.genre())
                .price(dto.price())
                .author(author)
                .build();

        return bookRepository.save(book);
    }

    public List<Book> index() {
        return bookRepository.findAll();
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
