package classroom.teaching.students.request;

import java.util.Set;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import classroom.teaching.students.helper.FormattedDate;

public class PostContentRequest {

	FormattedDate date = new FormattedDate();

	@NotBlank
	@Size(min = 1, max = 50)
	private String content = null;
	private String option = "post";
	private String schedule_date = date.FormattedDateValue();
	private String schedule_time = date.FormattedTime();
	private Set<UUID> tagId;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
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

	public Set<UUID> getTagId() {
		return tagId;
	}

	public void setTagId(Set<UUID> tagId) {
		this.tagId = tagId;
	}

}
