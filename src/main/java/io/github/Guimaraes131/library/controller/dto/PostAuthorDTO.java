package io.github.Guimaraes131.library.controller.dto;

import io.github.Guimaraes131.library.model.Author;

public record PostAuthorDTO(
        String name,
        String nationality
) {

    public Author toEntity() {
        return Author.builder()
                .name(this.name)
                .nationality(this.nationality)
                .build();
    }
}
