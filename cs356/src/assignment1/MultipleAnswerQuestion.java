package assignment1;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MultipleAnswerQuestion extends Question{

	private Map<String, ArrayList<Answer>> answers;
	private List<Answer> correct;

	/*
	 * Constructor for a question that has multiple answers. This class contains a 
	 * map to store votes so that no student can answer more than once. The key is 
	 * the student ID, and the value is an ArrayList of their choices made. All of these
	 * are initialized in the constructor.
	 */
	public MultipleAnswerQuestion(String q) {
		super(q);
		answers = new HashMap<String, ArrayList<Answer>>();
		correct = new ArrayList<Answer>();
	}

	/*
	 * Casts a student's vote. Overrides the values if they have already voted.
	 */
	public void setAnswers(Student s, ArrayList<Answer> a) {
		answers.put(s.getID(), a);
	}

	/*
	 * Adds a students vote to their currently selected answers. Will not override their 
	 * previous choices, just add to them.
	 */
	public void setAnswers(Student s, Answer a) {
		ArrayList<Answer> temp;
		if (answers.get(s.getID()) == null)
			temp = new ArrayList<Answer>();
		else
			temp = answers.get(s.getID());
		temp.add(a);
		answers.put(s.getID(), temp);
	}
	
	/*
	 * Adds an answer as to the correct answer list.
	 */
	public void addCorrectAnswer(Answer a) {
		correct.add(a);
	}
	
	/*
	 * Adds an answer choice to the question. Adds to the answer list. Boolean parameter
	 * determines whether or not to make it a correct answer or not.
	 */
	public void addAnswerChoice(Answer a, boolean c) {
		if (c)
			correct.add(a);
		addAnswerChoice(a);
	}
	
	/*
	 * Iterates through the map of votes and tallies up the number of responses
	 * per answer choice. Returns the results in a new Map using String key and Integer 
	 * Value.
	 */
	public Map<String, Integer> getResults() {
		Map<String, Integer> ret = new HashMap<String, Integer>();
		for (ArrayList<Answer> al: answers.values()) {
			for (Answer value: al ) {
				int temp = ret.get(value.toString()) == null ? 0 : ret.get(value.toString());
				temp++;
				ret.put(value.toString(), temp);
			}
		}
		return ret;
	}
	
	/*
	 * Getter method for the correct answers list.
	 */
	public ArrayList<Answer> getCorrect() {
		return (ArrayList<Answer>) correct;
	}

}
