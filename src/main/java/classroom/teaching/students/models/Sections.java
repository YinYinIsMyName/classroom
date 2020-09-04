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

@Entity
@Table(name = "create_class")
public class Sections implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7725003993596470788L;
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "class_id", updatable = false, nullable = false, unique = true)
	private UUID uuid;
	@Column(name = "user_id", nullable = true)
	private UUID userId;
	@Column(name = "key_disable_bit")
	private boolean keyIsDisable;
	@Column(name = "class_unique_code")
	private String uniqueKey;
	@Column(name = "reset_code")
	private String newCode;
	@Column(name = "classname", nullable = false)
	private String sectionName;
	@Column(name = "section")
	private String section;
	@Column(name = "room")
	private String room;
	@Column(name = "subject")
	private String subject;
	@Column(name = "stream")
	private int stream;
	@Column(name = "show_items")
	private boolean show_items;
	@Column(name = "get_time")
	private String currentTime;

	@ManyToOne(optional = true, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", updatable = false, insertable = false)
	private User user;

	@OneToMany(mappedBy = "sections", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Join> joinSections = new HashSet<Join>();
	@OneToMany(mappedBy = "sections", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<PostContent> postContent = new HashSet<PostContent>();

	public Sections() {
	}

	public Sections(UUID userId, String uniqueKey, String newCode, String classname, String section, String room,
			String subject, String currentTime) {
		super();
		this.userId = userId;
		this.uniqueKey = uniqueKey;
		this.newCode = newCode;
		this.sectionName = classname;
		this.section = section;
		this.room = room;
		this.subject = subject;
		this.currentTime = currentTime;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getUniqueKey() {
		return uniqueKey;
	}

	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}

	public String getNewCode() {
		return newCode;
	}

	public void setNewCode(String newCode) {
		this.newCode = newCode;
	}

	public String getClassname() {
		return sectionName;
	}

	public void setClassname(String classname) {
		this.sectionName = classname;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getStream() {
		return stream;
	}

	public void setStream(int stream) {
		this.stream = stream;
	}

	public boolean isShow_items() {
		return show_items;
	}

	public void setShow_items(boolean show_items) {
		this.show_items = show_items;
	}

	public String getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}

	public boolean isKeyIsDisable() {
		return keyIsDisable;
	}

	public void setKeyIsDisable(boolean keyIsDisable) {
		this.keyIsDisable = keyIsDisable;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public Set<Join> getJoinSections() {
		return joinSections;
	}

	public void setJoinSections(Set<Join> joinSections) {
		this.joinSections = joinSections;
	}

}
