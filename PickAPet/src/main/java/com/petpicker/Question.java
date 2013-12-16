package com.petpicker;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

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
	NodeList nList;

	public Question() {

		answered = false;
		aboutPet = false;
		questionText = "";
		property = "";
		answers = null;
	}

	public Question(boolean ifAnimal, String questionText, String property,
			ArrayList<String> answers) {
		answered = false;
		this.aboutPet = ifAnimal;
		this.questionText = questionText;
		this.property = property;
		this.answers = answers;
	}

	public void setQuestion(String questionName) {

		try {

			File fXmlFile = new File("questions.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("question");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					if (eElement.getAttribute("id").equals(questionName)) {
						
						    this.answers = new ArrayList<String>();
						
							int answersNumber = Integer.parseInt(eElement
									.getElementsByTagName("answersNumber")
									.item(0).getTextContent());
														
							while (this.answers.size()<answersNumber){
								this.answers.add("");
							}
							
							if (answersNumber <= 3){
								this.answers.set(0, eElement
									.getElementsByTagName("first")
									.item(0).getTextContent());
								this.answers.set(1, eElement
										.getElementsByTagName("second")
										.item(0).getTextContent());
							}
							
							if ((answersNumber < 5) && (answersNumber >2)){
								this.answers.set(2, eElement
										.getElementsByTagName("third")
										.item(0).getTextContent());
								
							}
							if (answersNumber == 4 ){
								this.answers.set(3, eElement
										.getElementsByTagName("fourth")
										.item(0).getTextContent());
							}
													
							this.questionText = eElement
									.getElementsByTagName("questionText")
									.item(0).getTextContent();
							this.property = eElement
									.getElementsByTagName("property").item(0)
									.getTextContent();
							if (eElement.getElementsByTagName("aboutPet")
									.item(0).getTextContent().equals("tak")) {
								this.aboutPet = true;
							} else {
								this.aboutPet = false;
							}
						
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Question(Question question) {
		this.answered = question.answered;
		this.aboutPet = question.aboutPet;
		this.questionText = question.questionText;
		this.property = question.property;
		for (String sourceAnswers : question.answers) {
			answers.add(sourceAnswers);
		}
	}

	public void updatePet(Pet pet, int selected) {
		pet.setProperty(this.property, answers.get(selected));
	}

	public void updatePerson(Person person, int selected) {
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
