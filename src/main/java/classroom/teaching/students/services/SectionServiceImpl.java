package classroom.teaching.students.services;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import classroom.teaching.students.models.Sections;
import classroom.teaching.students.repository.SectionReposistory;

@Service
public class SectionServiceImpl {

	@Autowired
	SectionReposistory sectionRepo;

	@Transactional
	public void store(Sections section) {
		sectionRepo.save(section);

	}

	public Sections readSections(String code) {
		Sections section = sectionRepo.findByNewCode(code);
		return section;
	}
}
