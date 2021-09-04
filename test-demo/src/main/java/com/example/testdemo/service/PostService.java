package com.example.testdemo.service;

import com.example.testdemo.model.Post;

import java.util.List;

public interface PostService {

    public List<Post> getAll();
    public Post getById(int id);
    public Post addPost(Post post);
}
