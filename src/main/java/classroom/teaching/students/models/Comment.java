package classroom.teaching.students.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "post_comment")
public class Comment {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "comment_id", updatable = false, nullable = false, unique = true)
	private UUID uuid;
	@Column(name = "user_id")
	private UUID userId;
	@Column(name = "post_id")
	private UUID postId;
	private String comments;
	@Column(name = "now_time")
	private String current_time;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", updatable = false, insertable = false)
	private User user;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "post_id", referencedColumnName = "post_id", updatable = false, insertable = false)
	private PostContent postcontent;

	public Comment() {
	}

	public Comment(UUID userId, UUID postId, String comments, String current_time) {
		super();
		this.userId = userId;
		this.postId = postId;
		this.comments = comments;
		this.current_time = current_time;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public UUID getPostId() {
		return postId;
	}

	public void setPostId(UUID postId) {
		this.postId = postId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCurrent_time() {
		return current_time;
	}

	public void setCurrent_time(String current_time) {
		this.current_time = current_time;
	}

}
