package by.anya.kuksa.server.dao;


import by.anya.kuksa.server.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClaimDAO extends JpaRepository<Claim, Integer>, JpaSpecificationExecutor<Claim> {
}
