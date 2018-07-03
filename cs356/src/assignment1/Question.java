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
	
	public abstract boolean setAnswers(Student s, Answer a);
	
	public void addAnswerChoice(Answer a) {
		possibleAnswers.add(a);
	}
	
	public abstract void addAnswerChoice(Answer a, boolean correct);
	
	public abstract void addCorrectAnswer(Answer a);
	
	public abstract int getNumberCorrect();
	
	public String getQuestion() {
		return q;
	}
	
	public void setQuestion(String q) {
		this.q = q;
	}
	
	public List<Answer> getPossibleAnswers() {
		return possibleAnswers;
	}
	
	public abstract Map<String, Integer> getResults();
}
