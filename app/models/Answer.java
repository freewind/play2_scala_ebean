package models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.db.ebean.Model;

@SuppressWarnings("serial")
@Entity
@Table(name = "answers")
public class Answer extends Model {

	@Id
	public Long id;

	public String content;

	@ManyToOne
	public Question question;

	@ManyToOne
	public User user;

	public Date createdAt = new Date();

	public static Finder<Long, Answer> find = new Finder<Long, Answer>(Long.class, Answer.class);

	public Answer(String content, Question question, User user) {
		this.content = content;
		this.question = question;
		this.user = user;
	}

}
