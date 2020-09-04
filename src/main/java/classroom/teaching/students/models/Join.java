package classroom.teaching.students.models;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "join_table")
public class Join {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "join_id", unique = true, nullable = false)
	private int id;
	@Column(name = "user_id", nullable = true)
	private UUID userId;
	@Column(name = "reset_code")
	private String classCode;

	@Column(name = "get_time")
	private String current_time;

	@ManyToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", updatable = false, insertable = false)
	private User user;

	@JsonBackReference
	@ManyToOne(optional = true, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "reset_code", referencedColumnName = "reset_code", updatable = false, insertable = false)
	private Sections sections;

	public Join() {
	}

	public Join(UUID userId, String classCode, String current_time) {
		super();
		this.classCode = classCode;
		this.userId = userId;
		this.current_time = current_time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurrent_time() {
		return current_time;
	}

	public void setCurrent_time(String current_time) {
		this.current_time = current_time;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public Sections getSections() {
		return sections;
	}

	public void setSections(Sections sections) {
		this.sections = sections;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	

}
