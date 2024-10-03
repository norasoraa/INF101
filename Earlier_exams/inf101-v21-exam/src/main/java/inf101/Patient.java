package inf101;

public class Patient implements Comparable<Patient> {

	private String name;
	private UnderlyingConditionGrade underlyingConditionGrade;
	private int age;
	
	public Patient(String name, int age, UnderlyingConditionGrade underlyingCondition) {
		this.name = name;
		this.age = age;
		this.underlyingConditionGrade = underlyingCondition;
	}
	
	public String getName() {
		return name;
	}
	
	// SOLUTION HERE ======
	@Override
	public int compareTo(Patient o) {
		if (this.underlyingConditionGrade.getValue() != o.underlyingConditionGrade.getValue()) {
			return Integer.compare(o.underlyingConditionGrade.getValue(), this.underlyingConditionGrade.getValue());
		} else {
			return Integer.compare(o.age, this.age);
		}
	}
	// ====================
}
