package com.example.testdemo.repository;

import com.example.testdemo.model.PostV2;
import org.springframework.http.ResponseEntity;

public interface PostRepositoryV2 {
    public ResponseEntity<?> getPostsV2();

    public ResponseEntity<?>  getByIdV2(int id);

    public ResponseEntity<?>  addPostV2(PostV2 post);

    public ResponseEntity<?>  updatePostV2(int id, PostV2 post);

    public ResponseEntity<?> deletePostV2(int id);
}
