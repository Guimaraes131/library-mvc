package io.github.Guimaraes131.library.model;

public enum Genre {
    FICTION("Ficção"),
    ROMANCE("Romance"),
    BIOGRAPHY("Biografia"),
    SCIENCE("Ciência");

    private final String value;

    Genre(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
