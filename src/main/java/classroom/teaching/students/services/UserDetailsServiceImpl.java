package classroom.teaching.students.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import classroom.teaching.students.models.Join;
import classroom.teaching.students.models.User;
import classroom.teaching.students.repository.UserReposistory;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserReposistory userRepo;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userByName = userRepo.findByUsername(username);
		try {
			if (username.contains(userByName.getUsername())) {
				return UserDetailsImpl.build(userByName);
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new UsernameNotFoundException("user 404");
		}

	}

}
