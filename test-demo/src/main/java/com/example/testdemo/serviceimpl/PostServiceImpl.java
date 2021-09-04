package com.example.testdemo.serviceimpl;

import com.example.testdemo.model.Post;
import com.example.testdemo.repository.PostRepository;
import com.example.testdemo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> getAll() {
        return postRepository.getAll();
    }

    @Override
    public Post getById(int id) {
        return postRepository.getById(id);
    }

    @Override
    public Post addPost(Post post) {
        return postRepository.addPost(post);
    }
}
