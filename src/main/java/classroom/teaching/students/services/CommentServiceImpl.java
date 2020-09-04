package classroom.teaching.students.services;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import classroom.teaching.students.models.Comment;
import classroom.teaching.students.repository.CommentRepository;
import classroom.teaching.students.request.CommentRequest;

@Service
public class CommentServiceImpl {

	@Autowired
	CommentRepository commentRepo;

	@Transactional
	public void storeComment(UUID userId, UUID postId, CommentRequest request) {
		Comment comment = new Comment(userId, postId, request.getComments(), request.getCurrent_time());
		commentRepo.save(comment);
	}

	public List<Comment> fetchComment(UUID postId) {
		List<Comment> comment = commentRepo.findAllByPostId(postId);

		return comment;
	}

}
