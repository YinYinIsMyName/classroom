package classroom.teaching.students.helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class FormattedDate {

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	DateTimeFormatter dtft = DateTimeFormatter.ofPattern("hh:mm a");
	LocalDateTime now = LocalDateTime.now();
	String formattedDate = dtf.format(now);
	String formattedTime = dtft.format(now);

	public String FormattedDateValue() {
		return formattedDate;
	}

	public String FormattedTime() {
		return formattedTime;
	}
}
