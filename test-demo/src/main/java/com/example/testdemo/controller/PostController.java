package com.example.testdemo.controller;

import com.example.testdemo.model.Post;
import com.example.testdemo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> posts() {
        return postService.getAll();
    }

    @GetMapping(value="/{id}")
    public Post getPostById(@PathVariable("id") int id) {
        return postService.getById(id);
    }

    @PostMapping
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }
}
