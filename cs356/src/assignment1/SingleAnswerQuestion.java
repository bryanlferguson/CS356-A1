package assignment1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class SingleAnswerQuestion extends Question{

	private Map<String, Answer> answers;
	private Answer correct;
	
	/*
	 * Constructor for single answer question. Initializes the question string using super
	 * and initializes the HashMap to store student answers. Since each student can only answer
	 * with one answer, it does not need to be a list. Additionally, the correct answer does not
	 * need to be a list either.
	 */
	public SingleAnswerQuestion(String q) {
		super(q);
		answers = new HashMap<String, Answer>();
	}
	
	/*
	 * Sets a student's vote given a student and an answer.
	 */
	public void setAnswers(Student s, Answer a) {
		answers.put(s.getID(), a);
	}
	
	/*
	 * Changes the correct answer.
	 */
	public void addCorrectAnswer(Answer a) {
		correct = a;
	}
	
	/*
	 * Adds an answer choice to the correct answers list. The boolean value 
	 * determines whether or not is is a correct answer.
	 */
	public void addAnswerChoice(Answer a, boolean c) {
		if (c)
			correct = a;
		addAnswerChoice(a);
	}
	
	/*
	 * Returns the correct answers for this question. The list will always have a 
	 * length of one.
	 */
	public ArrayList<Answer> getCorrect() {
		ArrayList<Answer> ret = new ArrayList<Answer>();
		ret.add(correct);
		return ret;
	}
	
	/*
	 * Tallies the results from the vote and returns it as a Map with key string and 
	 * value integer. 
	 */
	public Map<String, Integer> getResults() {
		Map<String, Integer> ret = new HashMap<String, Integer>();
		for (Answer value: answers.values()) {
			int temp = ret.get(value.toString()) == null ? 0 : ret.get(value.toString());
			temp++;
			ret.put(value.toString(), temp);
		}
		return ret;
	}
	
}
