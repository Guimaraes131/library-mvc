package io.github.Guimaraes131.library.repository;

import io.github.Guimaraes131.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
