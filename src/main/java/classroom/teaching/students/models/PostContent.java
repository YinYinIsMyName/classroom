package classroom.teaching.students.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "post_content")
public class PostContent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8483086008050953818L;
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "post_id", updatable = false, nullable = false, unique = true)
	private UUID uuid;
	@Column(name = "class_id", nullable = true)
	private UUID classId;
	@Column(name = "user_id", nullable = true)
	private UUID userId;
	@Column(name = "options")
	private String option;
	@Column(name = "contents")
	private String contents;
	private String schedule_date;
	private String schedule_time;

	@OneToMany(mappedBy = "postcontent", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Tag> tagLists = new HashSet<Tag>();

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "class_id", referencedColumnName = "class_id", updatable = false, insertable = false)
	private Sections sections;

	@OneToMany(mappedBy = "postcontent", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Comment> comments = new HashSet<Comment>();

	public PostContent() {
	}

	public PostContent(UUID classId, UUID userId, String option, String contents, String schedule_date,
			String schedule_time) {
		super();
		this.classId = classId;
		this.userId = userId;
		this.option = option;
		this.contents = contents;
		this.schedule_date = schedule_date;
		this.schedule_time = schedule_time;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public UUID getClassId() {
		return classId;
	}

	public void setClassId(UUID classId) {
		this.classId = classId;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getSchedule_date() {
		return schedule_date;
	}

	public void setSchedule_date(String schedule_date) {
		this.schedule_date = schedule_date;
	}

	public String getSchedule_time() {
		return schedule_time;
	}

	public void setSchedule_time(String schedule_time) {
		this.schedule_time = schedule_time;
	}


	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Tag> getTagLists() {
		return tagLists;
	}

	public void setTagLists(Set<Tag> tagLists) {
		this.tagLists = tagLists;
	}

}
