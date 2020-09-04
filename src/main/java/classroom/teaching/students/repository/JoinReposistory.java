package classroom.teaching.students.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import classroom.teaching.students.models.Join;

public interface JoinReposistory extends JpaRepository<Join, UUID> {

}
