package assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class IVoteService {
	private Question q;
	private List<Student> students;
	
	/*
	 * Constructor for IVoteService. Initializes the list of students.
	 */
	public IVoteService() {
		students = new ArrayList<Student>();
	}
	
	/*
	 * Sets the question string, as well as if the question will take multiple answers.
	 * Creates a new Question object accordingly.
	 */
	public void setQuestion(String ques, boolean multipleAnswers) {
		if (multipleAnswers) {
			q = new MultipleAnswerQuestion(ques);
		} else
			q = new SingleAnswerQuestion(ques);
	}
	
	/*
	 * Standard getter for question.
	 */
	public Question getQuestion() {
		return q;
	}
	
	/*
	 * Standard setter for student.
	 */
	public void addStudent(Student s) {
		students.add(s);
	}
	
	/*
	 * Adds a new student to the list. Generates with a random ID and returns
	 * the new Student object.
	 */
	public Student addRandomStudent() {
		Student stu = new Student(Integer.toString((int) (Math.random() * 100000000)));
		students.add(stu);
		return stu;
	}
	
	/*
	 * Standard getter for students list.
	 */
	public List<Student> getStudents(){
		return students;
	}
	
	/*
	 * Compiles results from the question votes and prints the number of correct responses
	 * and incorrect responses. Uses the getResults() method from the Question class to 
	 * do this.
	 */
	public void printResults() {
		Map<String, Integer> res = q.getResults();
		int correct = 0;
		int total = 0;
		for (Entry<String, Integer> pair: res.entrySet()) {
			System.out.println(pair.getKey().toString() + "\t" + pair.getValue());
			for (Answer a : q.getCorrect()) {
				if (a.getAnswer() == pair.getKey().toString())
					correct += pair.getValue();	
			}
			total += pair.getValue();
		}
		System.out.println("Number correct: " + correct);
		System.out.println("Number incorrect: " + (total - correct));
	}
	
	/*
	 * Casts a vote for a student given a student and an answer. This is mostly 
	 * just a wrapper for setAnswers in Question.
	 */
	public void vote(Student s, Answer a) {
		q.setAnswers(s, a);
	}
	
	/*
	 * Default for creating a question accepting multiple answers with answer choices A,B,C,D
	 * Each answer choice has 50% chance of being a correct answer
	 */
	public void setABCDMultiple() {
		q.addAnswerChoice(new Answer("A"), Math.random() < .5);
		q.addAnswerChoice(new Answer("B"), Math.random() < .5);
		q.addAnswerChoice(new Answer("C"), Math.random() < .5);
		q.addAnswerChoice(new Answer("D"), Math.random() < .5);
		
	}
	/*
	 * Default for creating a question accepting single answer with answer choices A,B,C,D
	 * Each answer choice has an equal chance of being the correct one.
	 */
	public void setABCDSingle() {
		int c = (int) (Math.random() * 4);
		q.addAnswerChoice(new Answer("A"), c == 0);
		q.addAnswerChoice(new Answer("B"), c == 1);
		q.addAnswerChoice(new Answer("C"), c == 2);
		q.addAnswerChoice(new Answer("D"), c == 3);
	}
}
