package key.essens.blogsite.service.api;

import key.essens.blogsite.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> search(String name);
}
