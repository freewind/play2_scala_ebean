package models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("answer")
public class AnswerComment extends Comment {

	@ManyToOne
	public Answer anser;

}
