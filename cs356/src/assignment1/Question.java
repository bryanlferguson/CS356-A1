package assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Question {
	
	private String q;
	private List<Answer> possibleAnswers;
	
	/*
	 * Constructor for question. Initializes possibleAnswers list and question string.
	 */
	public Question(String q) {
		possibleAnswers = new ArrayList<Answer>();
		this.q = q;
	}
	
	/*
	 * Abstract method for setting answers. Will differ in subclasses.
	 */
	public abstract void setAnswers(Student s, Answer a);
	
	/*
	 * Adds an answer choice to the possibleAnswers list.
	 */
	public void addAnswerChoice(Answer a) {
		possibleAnswers.add(a);
	}
	
	/*
	 * Abstract method for addingAnswerChoice. Will differ in subclasses.
	 */
	public abstract void addAnswerChoice(Answer a, boolean correct);
	
	/*
	 * Abstract method for addingCorrectAnswers. Differs in subclasses based
	 * on number of correct choices.
	 */
	public abstract void addCorrectAnswer(Answer a);
	
	/*
	 * Standard getter to retrieve question string.
	 */
	public String getQuestion() {
		return q;
	}
	
	/*
	 * Setter to set question string.
	 */
	public void setQuestion(String q) {
		this.q = q;
	}
	
	/*
	 * Returns list of possible answer choices.
	 */
	public List<Answer> getPossibleAnswers() {
		return possibleAnswers;
	}
	
	/*
	 * Abstract method to return results of vote.
	 */
	public abstract Map<String, Integer> getResults();

	/*
	 * Abstract method to return correct answers.
	 */
	public abstract ArrayList<Answer> getCorrect();
}
