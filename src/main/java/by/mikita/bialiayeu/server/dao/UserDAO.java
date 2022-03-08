package by.mikita.bialiayeu.server.dao;

import by.mikita.bialiayeu.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    User findUserByLoginAndPassword(@Param("login") String userLogin, @Param("password") String userPassword);

    User findUserByLogin(@Param("login") String userLogin);

}
