package kyungsu.project.projects.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kyungsu.project.projects.entity.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Integer>{
	
	public List<CartEntity> findByProductNameAndId(String productName, String Id);
	@Query("SELECT c FROM cart c WHERE id = ?1")
	public List<CartEntity> cartList(String id);

}
