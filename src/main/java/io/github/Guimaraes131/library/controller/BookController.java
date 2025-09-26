package io.github.Guimaraes131.library.controller;

import io.github.Guimaraes131.library.controller.dto.PostBookDTO;
import io.github.Guimaraes131.library.service.AuthorService;
import io.github.Guimaraes131.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("books", bookService.index());

        return "index";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("postBook", new PostBookDTO(
                "",
                "",
                null,
                null,
                null,
                null
        ));
        model.addAttribute("authors", authorService.index());

        return "bookForm";
    }

    @PostMapping("/form")
    public String create(PostBookDTO dto) {
        bookService.create(dto);

        return "redirect:/books";
    }
}
