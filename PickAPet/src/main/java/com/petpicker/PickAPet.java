package com.petpicker;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.FactHandle;

public class PickAPet {

	private static Pet pet;
	private static Person person;
	static FactHandle petHandle;
	static FactHandle personHandle;
	static StatefulKnowledgeSession ksession;
	
    public static final void main(String[] args) {
    	
        try {        	
            KnowledgeBase kbase = readKnowledgeBase();
            ksession = kbase.newStatefulKnowledgeSession();
            KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "PickAPet");
            
            pet = new Pet();
            person = new Person();
        	
            petHandle = ksession.insert(pet);
            personHandle = ksession.insert(person);
            
            MainWindow mw = new MainWindow(ksession, pet, petHandle, person, personHandle);
            mw.frame.setVisible(true);
               
            ksession.fireAllRules();
            
            logger.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private static KnowledgeBase readKnowledgeBase() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("Control.drl"), ResourceType.DRL);
        kbuilder.add(ResourceFactory.newClassPathResource("KnowledgeBase.drl"), ResourceType.DRL);
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0) {
            for (KnowledgeBuilderError error: errors) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        return kbase;
    }
    
	public static void updateKnowledge(Question question, int selectedAnswer){
		if (question.isAboutPet())
		{
			question.updatePet(pet, selectedAnswer);
			ksession.update(petHandle, pet);
		}
		else{
			question.updatePerson(person, selectedAnswer);
			ksession.update(personHandle, person);
		}
		ksession.fireAllRules();
	}

}
