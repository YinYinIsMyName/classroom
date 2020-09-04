package classroom.teaching.students.services;

import java.util.UUID;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import classroom.teaching.students.models.Join;
import classroom.teaching.students.repository.JoinReposistory;

@Service
public class JoinServiceImpl {

	@Autowired
	JoinReposistory joinRepo;

	@Transactional
	public void store(UUID userId,String code, String Date) {
		Join join = new Join(userId,code, Date);
		joinRepo.save(join);
	}
}
