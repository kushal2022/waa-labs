package com.example.testdemo.service;

import com.example.testdemo.model.Post;
import org.springframework.http.ResponseEntity;

public interface PostService {

    public ResponseEntity<?> getPosts();
    public ResponseEntity<?> getById(int id);
    public ResponseEntity<?> addPost(Post post);
    public ResponseEntity<?> updatePost(int id, Post post);
    public ResponseEntity<?> deletePost(int id);
}
