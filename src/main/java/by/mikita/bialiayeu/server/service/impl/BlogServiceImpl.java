package by.mikita.bialiayeu.server.service.impl;

import by.mikita.bialiayeu.server.dao.BlogDAO;
import by.mikita.bialiayeu.server.model.Blog;
import by.mikita.bialiayeu.server.model.Course;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BlogServiceImpl {
    @Autowired
    private BlogDAO blogDAO;
    private ModelMapper modelMapper;

    public BlogServiceImpl(BlogDAO blogDAO, ModelMapper modelMapper){
        this.modelMapper = modelMapper;
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

    public List<Blog> findAllBlogsByDesc(String desc){
        return blogDAO.findAllByDescription(desc);
    }

    public Blog findBlogById(int id){
        Optional<Blog> courseOptional = blogDAO.findById(id);
        Blog course = courseOptional.map( c -> modelMapper.map(c, Blog.class)).get();
        return course;
    }

}
