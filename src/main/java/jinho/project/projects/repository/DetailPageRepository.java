package jinho.project.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jinho.project.projects.entity.DetailPageEntity;


@Repository
public interface DetailPageRepository extends JpaRepository<DetailPageEntity, String>{

}
