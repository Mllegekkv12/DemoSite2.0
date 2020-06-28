package key.essens.blogsite.service.impl;

import key.essens.blogsite.dto.PostDto;
import key.essens.blogsite.service.api.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemPostService implements PostService {

    private ArrayList<PostDto> posts = new ArrayList<PostDto>(Arrays.asList(
            PostDto.builder()
                    .title("First title")
                    .body("First body")
                    .img("/img/office.jpg")
                    .build(),
            PostDto.builder()
                    .title("Second title")
                    .body("Second body")
                    .img("/img/sample.jpg")
                    .build(),
            PostDto.builder()
                    .title("Third title")
                    .body("Third body")
                    .img("/img/office.jpg")
                    .build()
    ));

    @Override
    public List<PostDto> search(String name) {
        return name != null && !name.isEmpty() ?
                posts.stream().filter(post ->
            post.getTitle().toLowerCase().matches(".*" + name.toLowerCase() + ".*")
        ).collect(Collectors.toList()) : posts;
    }
}
