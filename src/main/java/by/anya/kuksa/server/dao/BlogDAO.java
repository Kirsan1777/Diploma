package by.anya.kuksa.server.dao;

import by.anya.kuksa.server.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogDAO extends JpaRepository<Blog, Integer>, JpaSpecificationExecutor<Blog> {

    List<Blog> findAllByDescription(@Param("description") String description);

}
