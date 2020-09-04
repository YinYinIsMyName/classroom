package classroom.teaching.students.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import classroom.teaching.students.helper.FormattedDate;

public class JoinSectionRequest {

	FormattedDate date = new FormattedDate();
	@NotBlank
	@Size(min = 1, max = 20)
	private String unique_code;
	private String DateTime = date.FormattedDateValue();

	public String getUnique_code() {
		return unique_code;
	}

	public void setUnique_code(String unique_code) {
		this.unique_code = unique_code;
	}

	public String getDateTime() {
		return DateTime;
	}

	public void setDateTime(String dateTime) {
		DateTime = dateTime;
	}

}
