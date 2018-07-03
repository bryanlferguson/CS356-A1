package assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Question {
	
	private String q;
	private List<Answer> possibleAnswers;
	
	public Question(String q) {
		possibleAnswers = new ArrayList<Answer>();
		this.q = q;
	}
	
	public abstract void setAnswers(Student s, Answer a);
	
	public void addAnswerChoice(Answer a) {
	}
	
	public String getQuestion() {
		return q;
	}
	
	public void setQuestion() {
	}


}
