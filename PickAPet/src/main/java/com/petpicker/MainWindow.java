package com.petpicker;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.BorderLayout;

import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JRadioButton;

import org.drools.runtime.StatefulKnowledgeSession;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import org.drools.runtime.rule.FactHandle;

public class MainWindow {

	public JFrame frame;
	private final JButton Next = new JButton("Dalej");
	ArrayList<JRadioButton> radioButtons = new ArrayList<JRadioButton>();
	private JTextArea questionText ;
	JPanel optionsPanel;
	JPanel buttonPanel;
	private Question question = new Question(false, "Witaj!", "", null);
	private static Question newQuestion = new Question(false, "Witaj!", "", null);
	 
	/**
	 * Create the application.
	 */
	public MainWindow(StatefulKnowledgeSession ksession, Pet pet, FactHandle petHandle, Person person, FactHandle personHandle) {
		initialize(ksession, pet, petHandle, person, personHandle);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final StatefulKnowledgeSession ksession, final Pet pet, final FactHandle petHandle, final Person person, final FactHandle personHandle ) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel questionPanel = new JPanel();
		frame.getContentPane().add(questionPanel, BorderLayout.NORTH);
		
		questionText = new JTextArea();
		questionText.setWrapStyleWord(true);
		questionText.setBackground(UIManager.getColor("Menu.background"));
		questionText.setEditable(false);
		questionText.setText("Witaj w systemie eksperckim wspomagającym wybór zwierzęcia! Aby rozpocząć kliknij \"Dalej\".");
		questionText.setLineWrap(true);
		questionPanel.add(questionText);
		
		optionsPanel = new JPanel();
		optionsPanel.setBackground(new Color(238, 238, 238));
		frame.getContentPane().add(optionsPanel, BorderLayout.CENTER);
		optionsPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JRadioButton opt1 = new JRadioButton("New radio button");		
		JRadioButton opt2 = new JRadioButton("New radio button");			
		JRadioButton opt3 = new JRadioButton("New radio button");		
		JRadioButton opt4 = new JRadioButton("New radio button");
		
		optionsPanel.add(opt1);
		optionsPanel.add(opt2);
		optionsPanel.add(opt3);
		optionsPanel.add(opt4);
		radioButtons.add(opt1);
		radioButtons.add(opt2);
		radioButtons.add(opt3);
		radioButtons.add(opt4);
		
	    //only one button can be selected
		ButtonGroup bG = new ButtonGroup();
		bG.add(opt1);
		bG.add(opt2);
		bG.add(opt3);
		bG.add(opt4);
		
		//make all radio buttons invisible
		radioButtonsClear();
		
		buttonPanel = new JPanel();
		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		

		Next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int selected = getSelectionIndex();
				
				//update knowledge base with gathered knowledge
				if (selected > -1){
					PickAPet.updateKnowledge(question, selected);
				}
			
				setNewQuestion();	
			}
		});
		buttonPanel.add(Next);
	}
	
	public static void setQuestion(String questionName) {
		newQuestion.setQuestion(questionName);
	}
	
	public static void displayResults(String result, String imagePath){
		ResultWindow rw = new ResultWindow(result, imagePath);
		rw.setVisible(true);
	}
	
	private void setNewQuestion(){
		radioButtonsClear();
		
		questionText.setText(newQuestion.getQuestionText());
		for (int i = 0; i < newQuestion.answers.size(); i++)
		{
			if (i < radioButtons.size()){
				radioButtons.get(i).setText(newQuestion.answers.get(i));
				radioButtons.get(i).setVisible(true);
			}
			frame.repaint();
		}
		
		question = newQuestion;
	}
	
	private void radioButtonsClear(){
		for (int i = 0; i < radioButtons.size(); i++){
			radioButtons.get(i).setVisible(false);
			radioButtons.get(i).setSelected(false);
		}
	}
	
	private int getSelectionIndex(){
		int selected = -1;
		
		for (int i = 0; i < radioButtons.size(); i++){
			if (radioButtons.get(i).isSelected()){
				selected = i;
			}
		}
		
		return selected;
	}
}
