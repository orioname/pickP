package com.petpicker;

import java.util.ArrayList;
/*
 * Question contains the content of the question, possible answers 
 * and property of an object which is the subject of the question
 * e. g. question="How old are you?" property="age" 
 */
public class Question {

	private boolean answered;
	private boolean aboutPet;
	private String questionText;
	String property;
	ArrayList<String> answers;
	
	public Question(){
		answered = false;
		aboutPet = false;
		questionText = "";
		property = "";
		answers = null;
	}
	
	public Question(boolean ifAnimal, String questionText, String property, ArrayList<String> answers){
		answered = false;
		this.aboutPet = ifAnimal;
		this.questionText = questionText;
		this.property = property;
		this.answers = answers;
	}
	
	public void setQuestion(boolean ifAnimal, String questionText, String property, ArrayList<String> answers){
		this.aboutPet = ifAnimal;
		this.questionText = questionText;
		this.property = property;
		this.answers = answers;
	}
	
	public Question(Question question){
		this.answered = question.answered;
		this.aboutPet = question.aboutPet;
		this.questionText = question.questionText;
        this.property = question.property;
        for (String sourceAnswers : question.answers) {
            answers.add(sourceAnswers);
        }
	}
	
	public void updatePet(Pet pet, int selected){
		pet.setProperty(this.property, answers.get(selected));
	}
	
	public void updatePerson(Person person, int selected){
		person.setProperty(this.property, answers.get(selected));
	}
	
	public boolean isAnswered() {
		return answered;
	}
	public void setAnswered(boolean answered) {
		this.answered = answered;
	}
	public boolean isAboutPet() {
		return aboutPet;
	}
	public void setAboutPet(boolean aboutPet) {
		this.aboutPet = aboutPet;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public ArrayList<String> getAnswers() {
		return answers;
	}
	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}
		
}
