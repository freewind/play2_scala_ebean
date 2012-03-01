package models;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name = "tags")
public class Tag extends Model {

	@Id
	public Long id;

	public String name;

	public Date createdAt = new Date();

	public Date updatedAt;

	@ManyToMany
	@JoinTable(name = "question_tag_r")
	public List<Question> questions;

	public static Model.Finder<Long, Tag> find = new Finder<Long, Tag>(Long.class, Tag.class);

	public Tag(String name) {
		this.name = name;
	}

	public static Tag getByName(String tagName) {
		return find.where().eq("name", tagName).findUnique();
	}
}
