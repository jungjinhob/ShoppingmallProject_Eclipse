package kyungsu.project.projects.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kyungsu.project.projects.entity.CartPayEntity;
@Repository
public interface CartPayRepository extends JpaRepository<CartPayEntity, Integer>{
	@Query("SELECT c FROM cartpay c WHERE id = ?1")
	public List<CartPayEntity> cartList(String id);
}
