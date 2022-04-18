package by.mikita.bialiayeu.server.service.impl;

import by.mikita.bialiayeu.server.dao.BlogDAO;
import by.mikita.bialiayeu.server.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlogServiceImpl {
    @Autowired
    private BlogDAO blogDAO;

    public BlogServiceImpl(BlogDAO blogDAO){
        this.blogDAO = blogDAO;
    }

    public List<Blog> findAllBlogs(){
        return blogDAO.findAll(Sort.by(Sort.Order.desc("id")));
    }

    public void addBlog(Blog blog){
        blogDAO.save(blog);
    }

    public void deleteBlog(int idBlog){
        blogDAO.deleteById(idBlog);
    }

}
