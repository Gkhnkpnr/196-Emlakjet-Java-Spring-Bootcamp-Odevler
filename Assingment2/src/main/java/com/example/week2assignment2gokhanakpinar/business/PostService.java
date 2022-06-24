package com.example.week2assignment2gokhanakpinar.business;

import com.example.week2assignment2gokhanakpinar.core.utilities.results.DataResult;
import com.example.week2assignment2gokhanakpinar.core.utilities.results.Result;
import com.example.week2assignment2gokhanakpinar.entity.Post;
import com.example.week2assignment2gokhanakpinar.enums.Category;

import java.util.List;

public interface PostService {
    Result createPost(Post post);
    DataResult<Post> getPostById(int id);
    Result update(Post post,int id,String user);

    DataResult<List<Post>> findPostsByAuthor(String author);

    DataResult<List<Post>>findPostsByCategory(Category category);

    DataResult<List<Post>> findFirst3ByOrderByCreatedAtDesc();
}
