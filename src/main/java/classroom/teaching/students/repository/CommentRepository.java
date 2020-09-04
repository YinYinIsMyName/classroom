package classroom.teaching.students.repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import classroom.teaching.students.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, UUID> {

	List<Comment> findAllByPostId(UUID postId);
}
