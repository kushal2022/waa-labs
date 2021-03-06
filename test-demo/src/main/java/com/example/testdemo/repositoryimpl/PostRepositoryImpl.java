package com.example.testdemo.repositoryimpl;

import com.example.testdemo.errorHandler.ErrorHandleService;
import com.example.testdemo.model.Post;
import com.example.testdemo.model.PostV2;
import com.example.testdemo.repository.PostRepository;
import com.example.testdemo.response.ErrorResponse;
import com.example.testdemo.response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private List<Post> posts = new CopyOnWriteArrayList<>();

    @Autowired
    private ErrorHandleService errorHandlerService;

    @Override
    public ResponseEntity<?>  getPosts() {

        if(posts.size() > 0) {
            SuccessResponse successResponse = new SuccessResponse("The posts", posts, 200);
            return new ResponseEntity<>(successResponse, HttpStatus.OK);
        }else {
            ErrorResponse errorResponse = errorHandlerService.error("Posts doesn't exist..", 400, null);
            return new ResponseEntity<>(errorResponse, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> getById(int id) {
        if(posts.stream().anyMatch(p -> p.getId() == id)) {
            Post postById = posts.stream().filter(post -> post.getId() == id).findFirst().get();
            SuccessResponse successResponse = new SuccessResponse("Find the post by id.", postById, 200);
            return new ResponseEntity<>(successResponse, HttpStatus.OK);
        }else {
            ErrorResponse errorResponse = errorHandlerService.error("Invalid id", 400, null);
            return new ResponseEntity<>(errorResponse, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> addPost(@RequestBody Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
        SuccessResponse successResponse = new SuccessResponse("Successfully added", post, 200);
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }

    public ResponseEntity<?> updatePost( int id, @RequestBody Post post) {

        if(posts.stream().anyMatch(p -> p.getId() == id)) {
            posts.stream().forEach(p -> {
                if(p.getId() == id) {
                    p.setTitle(post.getTitle());
                    p.setContent(post.getContent());
                    p.setLikeNumber(post.getLikeNumber());
                }
            });
            Post postRes = posts.stream().filter(p -> p.getId() == id).findFirst().get();
            SuccessResponse successResponse = new SuccessResponse("Successfully Updated!!", postRes, 200);
            return new ResponseEntity<>(successResponse, HttpStatus.OK);
        }else {
            ErrorResponse errorResponse = errorHandlerService.error("Invalid id", 400, null);
            return new ResponseEntity<>(errorResponse, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> deletePost(int id) {

        if(posts.stream().anyMatch(p -> p.getId() == id)) {
            Post postResponse = posts.stream().filter(p -> p.getId() == id).findFirst().get();

            posts.removeIf(post -> post.getId() == id);
            SuccessResponse successResponse = new SuccessResponse("Successfully Deleted!!", postResponse,200);
            return new ResponseEntity<>(successResponse, HttpStatus.OK);
        }else {
            ErrorResponse errorResponse = errorHandlerService.error("Invalid id", 400, null);
            return new ResponseEntity<>(errorResponse, HttpStatus.OK);
        }
    }
}
