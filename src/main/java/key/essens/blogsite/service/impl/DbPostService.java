package key.essens.blogsite.service.impl;


import key.essens.blogsite.domain.Post;
import key.essens.blogsite.dto.PostDto;
import key.essens.blogsite.jpa.PostRepository;
import key.essens.blogsite.service.api.PostService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DbPostService implements PostService {

    private final PostRepository postRepository;

    public DbPostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDto> search(String name) {
        List<Post> posts = name!= null && !name.isEmpty() ?
                postRepository.findAllByTitleLike("%" + name + "%") : postRepository.findAll();

        return posts.stream().map(post -> PostDto.builder()
                .title(post.getTitle())
                .body(post.getBody())
                .img(post.getImg())
                .build()
        ).collect(Collectors.toList());
    }

//    @PostConstruct
//    public void setut(){
//        postRepository.saveAll(Arrays.asList(Post.builder()
//                        .title("First title")
//                        .body("First body")
//                        .img("/img/office.jpg")
//                        .build(),
//                Post.builder()
//                        .title("Second title")
//                        .body("Second body")
//                        .img("/img/sample.jpg")
//                        .build(),
//                Post.builder()
//                        .title("Third title")
//                        .body("Third body")
//                        .img("/img/office.jpg")
//                        .build()
//        ));
//    }
}
