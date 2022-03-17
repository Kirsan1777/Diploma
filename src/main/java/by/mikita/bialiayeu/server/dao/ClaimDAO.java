package by.mikita.bialiayeu.server.dao;


import by.mikita.bialiayeu.server.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClaimDAO extends JpaRepository<Claim, Integer>, JpaSpecificationExecutor<Claim> {
}