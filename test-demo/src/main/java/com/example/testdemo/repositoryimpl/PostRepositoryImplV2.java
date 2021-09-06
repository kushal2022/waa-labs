package com.example.testdemo.repositoryimpl;

import com.example.testdemo.errorHandler.ErrorHandleService;
import com.example.testdemo.model.PostV2;
import com.example.testdemo.repository.PostRepositoryV2;
import com.example.testdemo.response.ErrorResponse;
import com.example.testdemo.response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryImplV2 implements PostRepositoryV2 {

    private List<PostV2> posts = new ArrayList<>();

    @Autowired
    private ErrorHandleService errorHandlerService;

    @Override
    public ResponseEntity<?> getPostsV2() {
        if(posts.size() > 0) {
            SuccessResponse successResponse = new SuccessResponse("The posts", posts, 200);
            return new ResponseEntity<>(successResponse, HttpStatus.OK);
        }else {
            ErrorResponse errorResponse = errorHandlerService.error("Posts doesn't exist..", 400, null);
            return new ResponseEntity<>(errorResponse, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> getByIdV2(int id) {
        if(posts.stream().anyMatch(p -> p.getId() == id)) {
            PostV2 postById = posts.stream().filter(post -> post.getId() == id).findFirst().get();
            SuccessResponse successResponse = new SuccessResponse("Find the post by id.", postById, 200);
            return new ResponseEntity<>(successResponse, HttpStatus.OK);
        }else {
            ErrorResponse errorResponse = errorHandlerService.error("Invalid id", 400, null);
            return new ResponseEntity<>(errorResponse, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> addPostV2(PostV2 post) {
        post.setId(posts.size() + 1);
        posts.add(post);
        SuccessResponse successResponse = new SuccessResponse("Successfully added", post, 200);
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updatePostV2(int id, PostV2 post) {
        if(posts.stream().anyMatch(p -> p.getId() == id)) {
            posts.stream().forEach(p -> {
                if(p.getId() == id) {
                    p.setTitle(post.getTitle());
                    p.setContent(post.getContent());
                }
            });
            PostV2 postRes = posts.stream().filter(p -> p.getId() == id).findFirst().get();
            SuccessResponse successResponse = new SuccessResponse("Successfully Updated!!", postRes, 200);
            return new ResponseEntity<>(successResponse, HttpStatus.OK);
        }else {
            ErrorResponse errorResponse = errorHandlerService.error("Invalid id", 400, null);
            return new ResponseEntity<>(errorResponse, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> deletePostV2(int id) {
        if(posts.stream().anyMatch(p -> p.getId() == id)) {
            PostV2 postResponse = posts.stream().filter(p -> p.getId() == id).findFirst().get();

            posts.removeIf(post -> post.getId() == id);
            SuccessResponse successResponse = new SuccessResponse("Successfully Deleted!!", postResponse,200);
            return new ResponseEntity<>(successResponse, HttpStatus.OK);
        }else {
            ErrorResponse errorResponse = errorHandlerService.error("Invalid id", 400, null);
            return new ResponseEntity<>(errorResponse, HttpStatus.OK);
        }
    }
}
