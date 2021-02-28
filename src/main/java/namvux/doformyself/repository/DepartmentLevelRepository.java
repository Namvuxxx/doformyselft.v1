package namvux.doformyself.repository;

import namvux.doformyself.model.DepartmentLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentLevelRepository extends JpaRepository<DepartmentLevel, String> {
}
