package io.github.Guimaraes131.library.controller.dto;

import io.github.Guimaraes131.library.model.Genre;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PostBookDTO(
        String title,
        String description,
        LocalDate publicationDate,
        Genre genre,
        BigDecimal price,
        Long authorId
) {
}
