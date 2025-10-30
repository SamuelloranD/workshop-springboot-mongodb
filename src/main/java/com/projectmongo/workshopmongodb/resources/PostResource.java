package com.projectmongo.workshopmongodb.resources;

import com.projectmongo.workshopmongodb.domain.Post;
import com.projectmongo.workshopmongodb.domain.User;
import com.projectmongo.workshopmongodb.dto.UserDTO;
import com.projectmongo.workshopmongodb.resources.util.URL;
import com.projectmongo.workshopmongodb.services.PostService;
import com.projectmongo.workshopmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {

        Post obj = postService.findById((id));

        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {

        text = URL.decodeParam(text);

        List<Post> list = postService.findByTitle(text);

        return ResponseEntity.ok().body(list);
    }
}
