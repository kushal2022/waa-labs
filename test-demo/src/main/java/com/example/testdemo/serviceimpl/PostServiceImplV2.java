package com.example.testdemo.serviceimpl;

import com.example.testdemo.model.PostV2;
import com.example.testdemo.repository.PostRepositoryV2;
import com.example.testdemo.service.PostServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImplV2 implements PostServiceV2 {

    @Autowired
    PostRepositoryV2 postRepository;

    @Override
    public ResponseEntity<?> getPostsV2() {
        return postRepository.getPostsV2();
    }

    @Override
    public ResponseEntity<?> getByIdV2(int id) {
        return postRepository.getByIdV2(id);
    }

    @Override
    public ResponseEntity<?> addPostV2(PostV2 post) {
        return postRepository.addPostV2(post);
    }

    @Override
    public ResponseEntity<?> updatePostV2(int id, PostV2 post) {
        return postRepository.updatePostV2(id, post);
    }

    @Override
    public ResponseEntity<?> deletePostV2(int id) {
        return postRepository.deletePostV2(id);
    }
}
