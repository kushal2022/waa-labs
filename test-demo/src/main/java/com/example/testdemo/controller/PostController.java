package com.example.testdemo.controller;

import com.example.testdemo.model.Post;
import com.example.testdemo.model.PostV2;
import com.example.testdemo.response.SuccessResponse;
import com.example.testdemo.service.PostService;
import com.example.testdemo.service.PostServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping(headers = "POST-API-VERSION=1")
    public ResponseEntity<?> posts() {
        return postService.getPosts();
    }

    @GetMapping(value="{id}", headers = "POST-API-VERSION=1")
    public ResponseEntity<?> getPostById(@PathVariable("id") int id) {

        ResponseEntity<?> responseEntity = postService.getById(id);
        SuccessResponse successResponse = (SuccessResponse) responseEntity.getBody();
        Post post = (Post) successResponse.getObject();
        int pid = post.getId();

        EntityModel<Post> resource = EntityModel.of(post);
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn
                (this.getClass()).addPost(new Post())).withRel("AddPost"));
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn
                (this.getClass()).deletePost(pid)).withRel("DeletePost"));
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @PostMapping(headers = "POST-API-VERSION=1")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @DeleteMapping(value = "{id}", headers = "POST-API-VERSION=1")
    public ResponseEntity<?> deletePost(@PathVariable("id") int id) {
        return postService.deletePost(id);
    }

    @PutMapping(value = "/{id}", headers = "POST-API-VERSION=1")
    public ResponseEntity<?> updatePost(@PathVariable("id") int id, @RequestBody Post post) {
        return postService.updatePost(id, post);
    }


    @Autowired
    private PostServiceV2 postServiceV2;


    @GetMapping(headers = "POST-API-VERSION=2")
    public ResponseEntity<?> postsV2() {
        return postServiceV2.getPostsV2();
    }

    @GetMapping(value="{id}", headers = "POST-API-VERSION=2")
    public ResponseEntity<?> getPostByIdV2(@PathVariable("id") int id) {

        ResponseEntity<?> responseEntity = postServiceV2.getByIdV2(id);
        SuccessResponse successResponse = (SuccessResponse) responseEntity.getBody();
        PostV2 postV2 = (PostV2) successResponse.getObject();
        int pid = postV2.getId();

        EntityModel<PostV2> resource = EntityModel.of(postV2);
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn
                (this.getClass()).addPostV2(new PostV2())).withRel("AddPost"));
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn
                (this.getClass()).deletePostV2(pid)).withRel("DeletePost"));
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @PostMapping(headers = "POST-API-VERSION=2")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addPostV2(@RequestBody PostV2 post) {
        return postServiceV2.addPostV2(post);
    }

    @DeleteMapping(value = "{id}", headers = "POST-API-VERSION=2")
    public ResponseEntity<?> deletePostV2(@PathVariable("id") int id) {
        return postServiceV2.deletePostV2(id);
    }

    @PutMapping(value = "/{id}", headers = "POST-API-VERSION=2")
    public ResponseEntity<?> updatePostV2(@PathVariable("id") int id, @RequestBody PostV2 post) {
        return postServiceV2.updatePostV2(id, post);
    }

}
