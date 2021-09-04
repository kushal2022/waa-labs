package com.example.testdemo.repositoryimpl;

import com.example.testdemo.model.Post;
import com.example.testdemo.repository.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private List<Post> posts = new ArrayList<Post>(){
        {
           add(new Post(1, "Pizza", "This is tasty.", 20));
           add(new Post(2, "Football", "This is addiction for me.", 80));
           add(new Post(3, "Phone", "This is Iphone 13.", 100));
        }

    };

    @Override
    public List<Post> getAll() {
        return posts;
    }

    @Override
    public Post getById(int id) {
        return posts.stream().filter(post -> post.getId() == id).findFirst().get();
    }

    @Override
    public Post addPost(Post post) {
        posts.add(post);
        return post;
    }
}
