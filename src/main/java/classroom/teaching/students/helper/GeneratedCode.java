package classroom.teaching.students.helper;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class GeneratedCode {

	final private String ALPHA = "ABCDEFGHIJKLMNOPQRSTUV123456789";
	final private Random rng = new SecureRandom();

	private char randomChar() {
		return ALPHA.charAt(rng.nextInt(ALPHA.length()));
	}

	public String GenerateCode(int length, int spacing, char spaceChar) {
		StringBuilder sb = new StringBuilder();
		int spacer = 0;
		while (length > 0) {
			if (spacer == spacing) {
				sb.append(spaceChar);
				spacer = 0;
			}
			length--;
			spacer++;
			sb.append(randomChar());
		}
		return sb.toString();
	}
}
