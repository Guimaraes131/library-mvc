package io.github.Guimaraes131.library.controller;

import io.github.Guimaraes131.library.controller.dto.PostBookDTO;
import io.github.Guimaraes131.library.service.AuthorService;
import io.github.Guimaraes131.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String create(PostBookDTO dto, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) return "bookForm";

        bookService.create(dto);
        redirect.addFlashAttribute("message", "Livro adicionado com sucesso.");

        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {

        bookService.delete(id);
        redirect.addFlashAttribute("message", "Livro excluído com sucesso.");
        return "redirect:/books";
    }
}
