package io.github.Guimaraes131.library.controller;

import io.github.Guimaraes131.library.controller.dto.PostAuthorDTO;
import io.github.Guimaraes131.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("postAuthor", new PostAuthorDTO("", ""));

        return "authorForm";
    }

    @PostMapping("/form")
    public String create(PostAuthorDTO dto) {
        authorService.create(dto.toEntity());

        return "redirect:/books";
    }
}
