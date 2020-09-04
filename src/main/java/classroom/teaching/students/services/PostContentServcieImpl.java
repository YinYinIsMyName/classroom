package classroom.teaching.students.services;

import java.util.Set;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import classroom.teaching.students.models.PostContent;
import classroom.teaching.students.models.Tag;
import classroom.teaching.students.models.User;
import classroom.teaching.students.repository.PostContentRepository;
import classroom.teaching.students.repository.TagRepository;
import classroom.teaching.students.repository.UserReposistory;
import classroom.teaching.students.request.PostContentRequest;

@Service
public class PostContentServcieImpl {

	@Autowired
	PostContentRepository contentReposistory;
	@Autowired
	UserReposistory userReposistory;
	@Autowired
	TagRepository tagResposistory;

	@Transactional
	public void storeContent(PostContentRequest request, UUID userId, UUID classId) {
		Set<UUID> studentsId = request.getTagId();
		Tag tag = new Tag();
		PostContent contents = new PostContent(classId, userId, request.getOption(), request.getContent(),
				request.getSchedule_date(), request.getSchedule_time());

		if (studentsId.size() > 1) {
			for (UUID studentIds : studentsId) {
				User user = userReposistory.findByUserId(studentIds);
				tag.setUser(user);
				tag.setPostcontent(contents);
				this.contentReposistory.save(contents);
				contents.getTagLists().add(tag);
				this.contentReposistory.save(contents);

			}
		} else {

			User user = userReposistory.findByUserIdIn(studentsId);
			tag.setUser(user);
			tag.setPostcontent(contents);
			contents.getTagLists().add(tag);
			this.contentReposistory.save(contents);
			System.out.println(tag);

		}

	}

	public PostContent fetchAll(UUID userId) {

		PostContent content = contentReposistory.findByUserId(userId);
		return content;
	}

}
