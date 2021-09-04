package com.example.testdemo.repository;

import com.example.testdemo.model.Post;

import java.util.List;

public interface PostRepository {

    public List<Post> getAll();

    public Post getById(int id);

    public Post addPost(Post post);
}
