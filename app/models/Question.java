package models;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.db.ebean.Model;

@SuppressWarnings("serial")
@Entity
@Table(name = "questions")
public class Question extends Model {

	@Id
	public Long id;

	public String title;

	public String content;

	@OneToMany(cascade = CascadeType.ALL)
	public List<Answer> answers;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "question_tag_r")
	public List<Tag> tags;

	public Date createdAt = new Date();

	public static Model.Finder<Long, Question> find = new Finder<Long, Question>(Long.class, Question.class);

	public Question(String title, String content) {
		this.title = title;
		this.content = content;
	}

}
