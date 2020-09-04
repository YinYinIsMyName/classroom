package classroom.teaching.students.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tag")
public class Tag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7249392708921984918L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tag_id;

	@ManyToOne(cascade = CascadeType.PERSIST,optional = true)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY,optional = true)
	@JoinColumn(name = "post_id", referencedColumnName = "post_id")
	private PostContent postcontent;

	public Tag() {
	};

	public Tag(User userId, PostContent postcontent) {
		super();
		this.user = userId;
		this.postcontent = postcontent;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User userId) {
		this.user = userId;
	}

	public PostContent getPostcontent() {
		return postcontent;
	}

	public void setPostcontent(PostContent postcontent) {
		this.postcontent = postcontent;
	}

}
