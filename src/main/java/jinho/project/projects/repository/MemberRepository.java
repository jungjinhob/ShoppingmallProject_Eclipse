package jinho.project.projects.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jinho.project.projects.entity.MemberEntity;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, String> {
	
	public boolean existsByIdAndPassword(String id, String password);
	public boolean existsByNumber(String number);
	public List<MemberEntity> findByNumber(String number);
	
	@Query("SELECT count(m.number) FROM member m WHERE id != ?1 AND number = ?2")
	public int numberResult(String id, String number);

}
