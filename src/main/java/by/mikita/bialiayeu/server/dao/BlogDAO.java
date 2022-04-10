package by.mikita.bialiayeu.server.dao;

import by.mikita.bialiayeu.server.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BlogDAO extends JpaRepository<Blog, Integer>, JpaSpecificationExecutor<Blog> {

}
