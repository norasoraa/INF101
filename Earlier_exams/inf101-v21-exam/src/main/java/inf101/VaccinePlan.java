package inf101;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VaccinePlan {

	public static void main(String[] args) {
		List<Patient> patients = getPatients();
		List<Vaccine> vaccines = getVaccines();

		//Continue here ...
		
	}
	
	private static void printVaccineAssignment(Patient patient, Vaccine vaccine) {
		System.out.println(patient.getName() + " får " + vaccine.getName() + "-vaksinen " + vaccine.getDeliveryDate() + ".");
	}

	
	private static List<Patient> getPatients() {
		return Arrays.asList(new Patient("Per", 43, UnderlyingConditionGrade.LOW),
				new Patient("Pål", 30, UnderlyingConditionGrade.NONE),
				new Patient("Anne", 51, UnderlyingConditionGrade.NONE),
				new Patient("Oddvar", 30, UnderlyingConditionGrade.HIGH),
				new Patient("Marie", 45, UnderlyingConditionGrade.NONE),
				new Patient("Gerd", 25, UnderlyingConditionGrade.MEDIUM));
	}

	private static List<Vaccine> getVaccines() {
		return Arrays.asList(
				new Pfizer(LocalDate.of(2021, 7, 1)), 
				new Moderna(LocalDate.of(2021, 8, 5)),
				new Pfizer(LocalDate.of(2021, 8, 16)), 
				new Moderna(LocalDate.of(2021, 8, 5)),
				new Pfizer(LocalDate.of(2021, 9, 3)), 
				new Pfizer(LocalDate.of(2021, 8, 16)));
	} 

}

