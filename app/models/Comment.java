package models;

import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name = "comments")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "comment_for", discriminatorType = DiscriminatorType.STRING)
public abstract class Comment extends Model {

	@Id
	public Long id;

	public String content;

	@ManyToOne
	public User user;

	public Date createdAt = new Date();

	public Date updatedAt;

}
