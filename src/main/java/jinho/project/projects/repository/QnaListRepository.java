package jinho.project.projects.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jinho.project.projects.entity.QnaListEntity;

@Repository
public interface QnaListRepository extends JpaRepository<QnaListEntity, Integer> {

	public List<QnaListEntity> findByOrderByNumDesc();
	
}
