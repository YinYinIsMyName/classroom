package classroom.teaching.students.response;

import java.util.Date;
import java.util.List;

import classroom.teaching.students.models.Comment;

public class CommentResponse {

	private String error = null;
	private List<Comment> commentLists;

	public CommentResponse() {
	}

	public CommentResponse(String error, List<Comment> commentLists) {
		super();
		this.error = error;
		this.commentLists = commentLists;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<Comment> getCommentLists() {
		return commentLists;
	}

	public void setCommentLists(List<Comment> commentLists) {
		this.commentLists = commentLists;
	}

	@Override
	public String toString() {
		return "CommentResponse [error=" + error + ", commentLists=" + commentLists + "]";
	}

}
