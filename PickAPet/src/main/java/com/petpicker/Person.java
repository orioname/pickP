package com.petpicker;

public class Person {
	
	private String age = "undefined";
	private String family = "undefined";
	private String timeAtHome = "undefined";
	private String children = "undefined";
	private String childrenAge = "undefined";
	private String homeType = "undefined";
	private String homeSurroundings = "undefined";
	private String allergy = "undefined";
	private String allergyType = "undefined";
	private String familyAllergy = "undefined";
	private String familyAllergyType = "undefined";
	private String otherAnimals = "undefined";
	private String activity = "undefined";
	
	public void setProperty(String property, String value){
		
		boolean success = true;
		
		if (property == "age"){
			this.age = value;
		}
		else if (property == "family"){
			this.family = value;
		}
		else if (property == "timeAtHome"){
			this.timeAtHome = value;
		}
		else if (property == "homeType"){
			this.homeType = value;
		}
		else if (property == "allergy"){
			this.allergy = value;
		}
		else if (property == "allergyType"){
			this.allergyType = value;
		}
		else if (property == "familyAllergy"){
			this.familyAllergy = value;
		}
		else if (property == "familyAllergyType"){
			this.familyAllergyType = value;
		}
		else if (property == "activity"){
			this.activity = value;
		}
		else if (property == "children"){
			this.children = value;
		}
		else if (property == "childrenAge"){
			this.childrenAge = value;
		}
		else if (property == "homeSurroundings"){
			this.homeSurroundings = value;
		}
		else if (property == "otherAnimals"){
			this.otherAnimals = value;
		}
		else{
			System.out.println("Person property not found:" + property);
		}
		
		if (success){
			System.out.println(property + " updated with value " + value );
		}
		
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getHomeType() {
		return homeType;
	}

	public void setHomeType(String homeType) {
		this.homeType = homeType;
	}

	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	public String getAllergyType() {
		return allergyType;
	}

	public void setAllergyType(String allergyType) {
		this.allergyType = allergyType;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public String getFamilyAllergy() {
		return familyAllergy;
	}

	public void setFamilyAllergy(String familyAllergy) {
		this.familyAllergy = familyAllergy;
	}

	public String getFamilyAllergyType() {
		return familyAllergyType;
	}

	public void setFamilyAllergyType(String familyAllergyType) {
		this.familyAllergyType = familyAllergyType;
	}

	public String getChildrenAge() {
		return childrenAge;
	}

	public void setChildrenAge(String childrenAge) {
		this.childrenAge = childrenAge;
	}

	public String getOtherAnimals() {
		return otherAnimals;
	}

	public void setOtherAnimals(String otherAnimals) {
		this.otherAnimals = otherAnimals;
	}

	public String getHomeSurroundings() {
		return homeSurroundings;
	}

	public void setHomeSurroundings(String homeSurroundings) {
		this.homeSurroundings = homeSurroundings;
	}

	public String getTimeAtHome() {
		return timeAtHome;
	}

	public void setTimeAtHome(String timeAtHome) {
		this.timeAtHome = timeAtHome;
	}
	
}
