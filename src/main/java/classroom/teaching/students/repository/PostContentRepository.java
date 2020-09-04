package classroom.teaching.students.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import classroom.teaching.students.models.PostContent;

public interface PostContentRepository extends JpaRepository<PostContent, UUID> {

	PostContent findByUserId(UUID userId);;
}
