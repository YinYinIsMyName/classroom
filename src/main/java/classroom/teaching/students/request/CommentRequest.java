package classroom.teaching.students.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import classroom.teaching.students.helper.FormattedDate;

public class CommentRequest {

	FormattedDate date = new FormattedDate();
	@NotBlank
	@Size(min = 1, max = 200)
	private String comments;
	private String current_time = date.FormattedDateValue();

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
