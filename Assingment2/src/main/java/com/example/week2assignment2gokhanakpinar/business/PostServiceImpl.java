package com.example.week2assignment2gokhanakpinar.business;

import com.example.week2assignment2gokhanakpinar.core.utilities.results.DataResult;
import com.example.week2assignment2gokhanakpinar.core.utilities.results.Result;
import com.example.week2assignment2gokhanakpinar.core.utilities.results.SuccessDataResult;
import com.example.week2assignment2gokhanakpinar.core.utilities.results.SuccessResult;
import com.example.week2assignment2gokhanakpinar.dataAccess.PostDao;
import com.example.week2assignment2gokhanakpinar.entity.Post;
import com.example.week2assignment2gokhanakpinar.enums.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    private PostDao postDao;

    @Autowired
    public PostServiceImpl(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public Result createPost(Post post) {
        this.postDao.save(post);
        return new SuccessResult("Post Eklendi");
    }

    @Override
    public DataResult<Post> getPostById(int id) {
        return new SuccessDataResult<Post>(this.postDao.getPostById(id), "Data Listelendi");
    }

    @Override
    public Result update(Post post,int id, String user) {
        this.postDao.findById(id).map(p -> {
            p.setAuthor(post.getAuthor());
            p.setUpdatedBy(user);
            p.setTitle(post.getTitle());
            p.setCategory(post.getCategory());
            p.setText(post.getText());
            p.setUpdatedAt(LocalDateTime.now());
            return this.postDao.save(p);
        });
        return new SuccessResult("Basariyla Guncellendi");
    }

    @Override
    public DataResult<List<Post>> findPostsByAuthor(String author) {
        return new SuccessDataResult<List<Post>>(this.postDao.findPostsByAuthor(author));
    }

    @Override
    public DataResult<List<Post>> findPostsByCategory(Category category) {
        return new SuccessDataResult<List<Post>>(this.postDao.findPostsByCategory(category));
    }

    @Override
    public DataResult<List<Post>> findFirst3ByOrderByCreatedAtDesc() {
        return new SuccessDataResult<List<Post>>(this.postDao.findFirst3ByOrderByCreatedAtDesc());
    }


}
