package key.essens.blogsite.controllers;

import key.essens.blogsite.service.api.PostService;
import key.essens.blogsite.service.impl.MemPostService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

    private PostService postService;

    public PostController(@Qualifier("dbPostService") PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String hello(Model model, @RequestParam(required = false) String name){

        model.addAttribute("posts", postService.search(name));
        return "hello";
    }
}
