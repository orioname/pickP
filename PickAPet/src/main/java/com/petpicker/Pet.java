package com.petpicker;

public class Pet {

	private String size = "undefined";
	private String species = "undefined";
	private String breed = "undefined";
	private String activity = "undefined";
	private String personality = "undefined";
	private String timeRequirements = "undefined";
	private String cost = "undefined";
	private String childFriendliness = "undefined";
	private String otherAnimalsFriendliness = "undefined";
	private String lifeExpectancy = "undefined";
	
	public void setProperty(String property, String value){
	
		boolean success = true;
		
		if (property.equals("size")){
			this.size = value;
		}
		else if (property.equals("species")){
			this.species = value;
		}
		else if (property.equals("breed")){
			this.breed = value;
		}
		else if (property.equals("activity")){
			this.activity = value;
		}
		else if (property.equals("personality")){
			this.personality = value;
		}
		else if (property.equals("timeRequirements")){
			this.timeRequirements = value;
		}
		else if (property.equals("cost")){
			this.cost = value;
		}
		else if (property.equals("childFriendliness")){
			this.childFriendliness = value;
		}
		else if (property.equals("otherAnimalsFriendliness")){
			this.otherAnimalsFriendliness = value;
		}
		else if (property.equals("lifeExpectancy")){
			this.lifeExpectancy = value;
		}
		else{
			System.out.println("Pet property not found:" + property);
			success = false;
		}
		
		if (success){
			System.out.println(property + " updated with value " + value );
		}
		
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public String getTimeRequirements() {
		return timeRequirements;
	}

	public void setTimeRequirements(String timeRequirements) {
		this.timeRequirements = timeRequirements;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getChildFriendliness() {
		return childFriendliness;
	}

	public void setChildFriendliness(String childFriendliness) {
		this.childFriendliness = childFriendliness;
	}

	public String getOtherAnimalsFriendliness() {
		return otherAnimalsFriendliness;
	}

	public void setOtherAnimalsFriendliness(String otherAnimalsFriendliness) {
		this.otherAnimalsFriendliness = otherAnimalsFriendliness;
	}

	public String getLifeExpectancy() {
		return lifeExpectancy;
	}

	public void setLifeExpectancy(String lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

}
