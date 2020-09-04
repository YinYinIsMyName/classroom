package classroom.teaching.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import classroom.teaching.students.models.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {

}
