package models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("question")
public class QuestionComment extends Comment {

	public Question question;

}
