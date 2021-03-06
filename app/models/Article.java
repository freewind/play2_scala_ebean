package models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name = "articles")
public class Article extends Model {

	@Id
	public  Long id;

	public  String content;

	public static Model.Finder<Long, Article> find = new Finder<Long, Article>(Long.class, Article.class);

}
