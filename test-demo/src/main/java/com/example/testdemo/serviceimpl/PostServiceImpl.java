package com.example.testdemo.serviceimpl;

import com.example.testdemo.model.Post;
import com.example.testdemo.repository.PostRepository;
import com.example.testdemo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public ResponseEntity<?> getPosts() {
        return postRepository.getPosts();
    }

    @Override
    public ResponseEntity<?> getById(int id) {
        return postRepository.getById(id);
    }

    @Override
    public ResponseEntity<?> addPost(Post post) {
        return postRepository.addPost(post);
    }

    @Override
    public ResponseEntity<?> updatePost(int id, Post post) {
        return postRepository.updatePost(id, post);
    }

    @Override
    public ResponseEntity<?> deletePost(int id) {
        return postRepository.deletePost(id);
    }
}
