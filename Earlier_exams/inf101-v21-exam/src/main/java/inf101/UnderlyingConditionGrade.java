package inf101;

public enum UnderlyingConditionGrade { 
	NONE(0), LOW(1), MEDIUM(2), HIGH(3);
	
	private int value;
	
	private UnderlyingConditionGrade(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}