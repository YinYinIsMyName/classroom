package classroom.teaching.students.response;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import classroom.teaching.students.models.Join;
import classroom.teaching.students.models.Sections;

public class JwtResponse {

	private String token;
	private String type = "Bearer";
	private String username;
	private UUID uuid;
	private Set<Sections> sections;
	private Set<Join> joinUserSections;

	public JwtResponse(String token, String username, UUID uuid, Set<Sections> sections, Set<Join> joinUser) {
		super();
		this.username = username;
		this.uuid = uuid;
		this.token = token;
		this.sections = sections;
		this.joinUserSections = joinUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Set<Sections> getSections() {
		return sections;
	}

	public void setSections(Set<Sections> sections) {
		this.sections = sections;
	}

	public Set<Join> getJoinUser() {
		return joinUserSections;
	}

	public void setJoinUser(Set<Join> joinUser) {
		this.joinUserSections = joinUser;
	}

	@Override
	public String toString() {
		return "JwtResponse [token=" + token + ", username=" + username + ", uuid=" + uuid + ", sections=" + sections
				+ ", joinUser=" + joinUserSections + "]";
	}

}
