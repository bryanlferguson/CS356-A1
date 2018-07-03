package assignment1;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MultipleAnswerQuestion extends Question{

	private Map<Integer, Answer> answers;

	public MultipleAnswerQuestion(String q) {
		super(q);
		answers = new HashMap<Integer, Answer>();
	}

	public void setAnswers(Student s, Answer a) {
		answers.put(s.getID(), a);
	}

}
