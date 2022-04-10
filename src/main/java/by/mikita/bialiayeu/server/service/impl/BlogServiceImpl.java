package by.mikita.bialiayeu.server.service.impl;

import by.mikita.bialiayeu.server.dao.BlogDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BlogServiceImpl {
    @Autowired
    private BlogDAO blogDAO;

    public BlogServiceImpl(BlogDAO blogDAO){
        this.blogDAO = blogDAO;
    }

}
