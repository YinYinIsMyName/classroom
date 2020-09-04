package classroom.teaching.students.services;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import classroom.teaching.students.models.Join;
import classroom.teaching.students.models.Sections;
import classroom.teaching.students.models.User;

public class UserDetailsImpl implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4999564553596838585L;
	private String name;
	private String password;
	private UUID userId;
	private Set<Sections> section;
	private Set<Join> joinUser;

	public UserDetailsImpl(String name, String password, UUID userId, Set<Sections> section, Set<Join> joinUser) {
		super();
		this.name = name;
		this.password = password;
		this.userId = userId;
		this.section = section;
		this.joinUser = joinUser;
	}

	public static UserDetailsImpl build(User user) {

		return new UserDetailsImpl(user.getUsername(), user.getUserpassword(), user.getUserId(), user.getSections(),
				user.getJoinUser());

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public Set<Sections> getSection() {
		return section;
	}

	public void setSection(Set<Sections> section) {
		this.section = section;
	}

	public Set<Join> getJoinUser() {
		return joinUser;
	}

	public void setJoinUser(Set<Join> joinUser) {
		this.joinUser = joinUser;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetailsImpl other = (UserDetailsImpl) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
