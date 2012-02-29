package models;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name = "tags")
public class Tag extends Model {

	public Long id;

	public String name;

	public Date createdAt = new Date();

	public Date updatedAt;

	public User user;

	public List<Question> questions;

	public static Finder<Long, Tag> find = new Finder<Long, Tag>(Long.class, Tag.class);

	public Tag(String name, User user) {
		this.name = name;
		this.user = user;
	}

	public static Tag getByName(String tagName) {
		return find.where().eq("name", tagName).findUnique();
	}
}
