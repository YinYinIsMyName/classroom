package classroom.teaching.students.models;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "user_id", columnDefinition = "BINARY(16)")
	private UUID userId;
	@Column(name = "name", nullable = false)
	private String username;
	@Column(name = "email", nullable = false)
	private String useremail;
	@Column(name = "password", nullable = false)
	private String userpassword;

	@JsonBackReference
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<Sections> sections = new HashSet<Sections>();

	@JsonBackReference
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<Join> joinUser = new HashSet<Join>();

	@JsonBackReference
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<Tag> tagLists = new HashSet<Tag>();
//	@JsonBackReference
//	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
//	private Set<Comment> commentsLists = new HashSet<Comment>();

	public User() {
	}

	public User(String username, String useremail, String userpassword) {
		super();
		this.username = username;
		this.useremail = useremail;
		this.userpassword = userpassword;

	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public Set<Sections> getSections() {
		return sections;
	}

	public void setSections(Set<Sections> sections) {
		this.sections = sections;
	}

	public Set<Join> getJoinUser() {
		return joinUser;
	}

	public void setJoinUser(Set<Join> joinUser) {
		this.joinUser = joinUser;
	}

}
