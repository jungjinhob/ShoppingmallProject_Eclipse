package kyungsu.project.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kyungsu.project.projects.entity.DetailPageEntity;


@Repository
public interface DetailPageRepository extends JpaRepository<DetailPageEntity, String>{

}
