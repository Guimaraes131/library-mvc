CREATE TABLE tb_book (
    id BIGSERIAL PRIMARY KEY,
    title TEXT NOT NULL UNIQUE,
    description TEXT,
    publication_date DATE NOT NULL,
    genre VARCHAR(9) NOT NULL,
    price NUMERIC(7, 2) NOT NULL,
    author_id BIGINT NOT NULL REFERENCES tb_author(id),
    CONSTRAINT chk_genre CHECK ( genre in ('FICTION', 'ROMANCE', 'BIOGRAPHY', 'SCIENCE') )
);