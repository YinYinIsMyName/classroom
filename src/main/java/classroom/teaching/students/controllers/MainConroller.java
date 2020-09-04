package classroom.teaching.students.controllers;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import classroom.teaching.students.models.Sections;
import classroom.teaching.students.request.CommentRequest;
import classroom.teaching.students.request.JoinSectionRequest;
import classroom.teaching.students.request.LoginRequest;
import classroom.teaching.students.request.PostContentRequest;
import classroom.teaching.students.request.SectionsRequest;
import classroom.teaching.students.request.UserRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/classroom")
public abstract class MainConroller {
	/*
	 * test
	 */
	public abstract void test();

	// yy-User Model Methods
	public abstract ResponseEntity<?> signup(UserRequest request);

	public abstract ResponseEntity<?> signin(LoginRequest request);

	// yy-create-section
	public abstract ResponseEntity<?> CreateSection(SectionsRequest request, String id);

	// yy-join section
	public abstract ResponseEntity<Sections> joinSection(JoinSectionRequest request, String id);

	// yy-post-content
	public abstract ResponseEntity<?> createPostContent(PostContentRequest request, String id, String classId);
	// yy-post-comment

	public abstract ResponseEntity<?> createComment(CommentRequest request, String userId, String postId);

	// yy---get comments
	public abstract ResponseEntity<?> fetchCommnet(String postId);
	//yy---get all values by content-id
	
	public abstract ResponseEntity<?> fetchAll(String classId);

}
