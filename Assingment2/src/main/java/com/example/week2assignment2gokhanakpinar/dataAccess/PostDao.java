package com.example.week2assignment2gokhanakpinar.dataAccess;

import com.example.week2assignment2gokhanakpinar.entity.Post;
import com.example.week2assignment2gokhanakpinar.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDao extends JpaRepository<Post, Integer> {
    Post getPostById(int id);
    List<Post> findPostsByAuthor(String author);
    List<Post> findPostsByCategory(Category category);
    List<Post> findFirst3ByOrderByCreatedAtDesc();
}
