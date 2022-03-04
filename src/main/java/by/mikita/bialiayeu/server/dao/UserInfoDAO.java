package by.mikita.bialiayeu.server.dao;


import by.mikita.bialiayeu.server.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserInfoDAO extends JpaRepository<UserInfo, Integer>, JpaSpecificationExecutor<UserInfo> {
}
