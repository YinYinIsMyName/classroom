package classroom.teaching.students.request;



import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;

import classroom.teaching.students.helper.FormattedDate;


public class SectionsRequest {
	FormattedDate date = new FormattedDate();
	@NotBlank
	@Size(min = 3, max = 100)
	private String classname;
	@Size(min = 1, max = 20)
	private String section;
	@Size(min = 3, max = 50)
	private String subject;
	@Size(min = 0, max = 50)
	private String room;
	private String UniqueCode;
	private String NewCode;
	private int stream = 1;
	private boolean ShowItems = false;
	private String DateTime = date.FormattedDateValue();

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getUniqueCode() {
		return UniqueCode;
	}

	public void setUniqueCode(String uniqueCode) {
		UniqueCode = uniqueCode;
	}

	public int getStream() {
		return stream;
	}

	public void setStream(int stream) {
		this.stream = stream;
	}

	public boolean isShowItems() {
		return ShowItems;
	}

	public void setShowItems(boolean showItems) {
		ShowItems = showItems;
	}

	public String getDateTime() {
		return DateTime;
	}

	public void setDateTime(String dateTime) {
		DateTime = dateTime;
	}

	public String getNewCode() {
		return NewCode;
	}

	public void setNewCode(String newCode) {
		NewCode = newCode;
	}

}
