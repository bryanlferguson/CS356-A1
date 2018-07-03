package assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class IVoteService {
	private Question q;
	private List<Student> students;
	private Scanner s;

	public IVoteService() {
		students = new ArrayList<Student>();
		s = new Scanner(System.in);
		s.close();
	}
	
	public void setQuestion(String ques, boolean multipleAnswers) {
		if (multipleAnswers) {
			q = new MultipleAnswerQuestion(ques);
		} else
			q = new SingleAnswerQuestion(ques);
	}
	
	public Question getQuestion() {
		return q;
	}
	
	public void addStudent(Student s) {
		students.add(s);
	}
	public Student addRandomStudent() {
		Student stu = new Student(Integer.toString((int) (Math.random() * 100000000)));
		students.add(stu);
		return stu;
	}
	public List<Student> getStudents(){
		return students;
	}
	
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
	
	public void printCorrect() {
		Map<String, Integer> res = q.getResults();
		for (Entry<String, Integer> pair: res.entrySet()) {
			System.out.println(pair.getKey().toString() + "\t" + pair.getValue());
		}
	}
	
	public void vote(Student s, Answer a) {
		q.setAnswers(s, a);
	}
	
	public void setABCD() {
		q.addAnswerChoice(new Answer("A"), Math.random() < .5);
		q.addAnswerChoice(new Answer("B"), Math.random() < .5);
		q.addAnswerChoice(new Answer("C"), Math.random() < .5);
		q.addAnswerChoice(new Answer("D"), Math.random() < .5);
		
	}
}
