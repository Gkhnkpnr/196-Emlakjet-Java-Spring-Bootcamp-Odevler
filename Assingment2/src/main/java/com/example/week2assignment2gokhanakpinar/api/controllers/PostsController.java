package com.example.week2assignment2gokhanakpinar.api.controllers;

import com.example.week2assignment2gokhanakpinar.business.PostService;
import com.example.week2assignment2gokhanakpinar.core.utilities.results.DataResult;
import com.example.week2assignment2gokhanakpinar.core.utilities.results.Result;
import com.example.week2assignment2gokhanakpinar.entity.Post;
import com.example.week2assignment2gokhanakpinar.enums.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostsController {
    private PostService postService;

    @Autowired
    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/add")
    public Result createPost(@RequestBody Post post){
        return this.postService.createPost(post);
    }

    @GetMapping("getById")
    public DataResult<Post> getPostById(int id){
        return this.postService.getPostById(id);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Post post, @RequestParam int id, @RequestParam String user){
        return this.postService.update(post, id, user);
    }

    @GetMapping("/getByAuthor")
    public DataResult<List<Post>> findPostsByAuthor(String author){
        return this.postService.findPostsByAuthor(author);
    }

    @GetMapping("/getByCategory")
    public DataResult<List<Post>> findPostsByCategory(Category category){
        return this.postService.findPostsByCategory(category);
    }

    @GetMapping("/getTop3")
    public DataResult<List<Post>> findFirst3ByOrderByCreatedAtDesc(){
        return this.postService.findFirst3ByOrderByCreatedAtDesc();
    }
}
