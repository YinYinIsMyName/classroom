package classroom.teaching.students.repository;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import classroom.teaching.students.models.User;

public interface UserReposistory extends JpaRepository<User, UUID> {

	User findByUsername(String username);

	User findByUserId(UUID studentsId);

	User findByUserIdIn(Set<UUID> studentId);
}
