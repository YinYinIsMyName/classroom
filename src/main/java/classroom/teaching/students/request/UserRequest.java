package classroom.teaching.students.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRequest {
	@NotBlank
	@Size(min = 1, max = 50)
	private String username;
	@NotBlank
	@Size(min = 1, max = 50)
	private String useremail;
	@NotBlank
	@Size(min = 1, max = 50)
	private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
