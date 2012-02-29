package models;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name = "users")
public class User extends Model {

	@Id
	public Long id;

	public String email;

	public String name;

	public String salt;

	public String password;

	public Date createdAt = new Date();

	@OneToMany
	public List<Question> questions;

	@OneToMany
	public List<Article> articles;

	@OneToMany
	public List<Answer> answers;

	@OneToMany
	public List<Tag> tags;

	public static Finder<Long, User> find = new Finder<Long, User>(Long.class, User.class);

	public User(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public static User getByEmail(String email) {
		return find.where().eq("email", email).findUnique();
	}
}
