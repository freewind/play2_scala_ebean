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

	public Date createdAt = new Date();

	public static Model.Finder<Long, Answer> find = new Finder<Long, Answer>(Long.class, Answer.class);

	public Answer(String content, Question question) {
		this.content = content;
		this.question = question;
	}

}
