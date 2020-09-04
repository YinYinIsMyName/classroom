package classroom.teaching.students.controllers;

import java.util.List;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import classroom.teaching.students.helper.GeneratedCode;
import classroom.teaching.students.models.Comment;
import classroom.teaching.students.models.PostContent;
import classroom.teaching.students.models.Sections;
import classroom.teaching.students.models.User;
import classroom.teaching.students.repository.UserReposistory;
import classroom.teaching.students.request.CommentRequest;
import classroom.teaching.students.request.JoinSectionRequest;
import classroom.teaching.students.request.LoginRequest;
import classroom.teaching.students.request.PostContentRequest;
import classroom.teaching.students.request.SectionsRequest;
import classroom.teaching.students.request.UserRequest;
import classroom.teaching.students.response.CommentResponse;
import classroom.teaching.students.response.JwtResponse;
import classroom.teaching.students.response.ResponseMessage;
import classroom.teaching.students.security.jwt.JwtUtils;
import classroom.teaching.students.services.CommentServiceImpl;
import classroom.teaching.students.services.JoinServiceImpl;
import classroom.teaching.students.services.PostContentServcieImpl;
import classroom.teaching.students.services.SectionServiceImpl;
import classroom.teaching.students.services.UserDetailsImpl;

@RestController
public class Controller extends MainConroller {

	@Autowired
	UserReposistory userRepo;
	@Autowired
	GeneratedCode randomCode;
	@Autowired
	SectionServiceImpl sectionService;
	@Autowired
	AuthenticationManager authenticationManger;
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JoinServiceImpl joinService;
	@Autowired
	PostContentServcieImpl contentService;
	@Autowired
	CommentServiceImpl commentService;

	@Override
	@GetMapping(path = "/test")
	public void test() {
		System.out.println("hello");
	}

	@Override
	@PostMapping(path = "/auth/signup")
	public ResponseEntity<?> signup(@Valid @RequestBody UserRequest request) {

		User user = new User(request.getUsername(), request.getUseremail(), encoder.encode(request.getPassword()));
		userRepo.save(user);
		return ResponseEntity.ok(new ResponseMessage("Your information has been added"));
	}

	@Override
	@PostMapping(path = "/auth/signin")
	public ResponseEntity<?> signin(@Valid @RequestBody LoginRequest request) {
		Authentication auth = authenticationManger
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(auth);
		String jwt = jwtUtils.generateJwtToken(auth);

		UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
		System.out.println(userDetails.getSection());
		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getName(), userDetails.getUserId(),
				userDetails.getSection(), userDetails.getJoinUser()));
	}

	@Override
	@PostMapping(path = "/create/classes")
	public ResponseEntity<?> CreateSection(@Valid @RequestBody SectionsRequest request, @RequestParam("id") String id) {

		String unquieCodes = randomCode.GenerateCode(6, 5, 'h');
		Sections section = new Sections(UUID.fromString(id), unquieCodes, unquieCodes, request.getClassname(),
				request.getSection(), request.getRoom(), request.getSubject(), request.getDateTime());
		sectionService.store(section);
		return ResponseEntity.ok(new ResponseMessage("section has been created"));
	}

	@Override
	@PostMapping(path = "/join/section")
	public ResponseEntity<Sections> joinSection(@Valid @RequestBody JoinSectionRequest request,
			@RequestParam("id") String userId) {
		String code = request.getUnique_code();
		UUID uuid = UUID.fromString(userId);
		Sections section = sectionService.readSections(code);
		joinService.store(uuid, code, request.getDateTime());
		if (section != null) {
			return new ResponseEntity<>(section, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	@PostMapping(path = "/create/postcontent")
	public ResponseEntity<?> createPostContent(@Valid @RequestBody PostContentRequest request,
			@RequestParam("userId") String id, @RequestParam("classId") String classId) {

		UUID userId = UUID.fromString(id);
		UUID classid = UUID.fromString(classId);

		contentService.storeContent(request, userId, classid);

		return ResponseEntity.ok(new ResponseMessage("contents have been created"));
	}

	@Override
	@PostMapping(path = "/create/comment")
	public ResponseEntity<?> createComment(@Valid @RequestBody CommentRequest request,
			@RequestParam("userId") String userId, @RequestParam("postId") String postId) {

		UUID userID = UUID.fromString(userId);
		UUID postID = UUID.fromString(postId);
		commentService.storeComment(userID, postID, request);
		return ResponseEntity.ok(new ResponseMessage("comments has been created"));
	}

	@Override
	@GetMapping(path = "/get/comment")
	public ResponseEntity<?> fetchCommnet(@RequestParam("postId") String postId) {
		UUID postID = UUID.fromString(postId);
		List<Comment> comment = commentService.fetchComment(postID);

		if (comment.size() > 0) {
			return new ResponseEntity<>(new CommentResponse(null, comment), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new CommentResponse("error", null), HttpStatus.OK);
		}

	}

	@Override
	@GetMapping(path = "/get/sections/comments")
	public ResponseEntity<PostContent> fetchAll(@RequestParam("userId") String userId) {

		UUID userID = UUID.fromString(userId);
		PostContent content = contentService.fetchAll(userID);
		if (content != null) {
			return new ResponseEntity<>(content, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
