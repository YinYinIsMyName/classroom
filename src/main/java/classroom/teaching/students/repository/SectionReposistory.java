package classroom.teaching.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import classroom.teaching.students.models.Sections;

public interface SectionReposistory extends JpaRepository<Sections, Long> {

	Sections findByNewCode(String code);
	
}
