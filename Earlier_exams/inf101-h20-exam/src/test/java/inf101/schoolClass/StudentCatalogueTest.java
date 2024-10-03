package inf101.schoolClass;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inf101.schoolClass.Student;
import inf101.schoolClass.StudentCatalogue;

class StudentCatalogueTest {

	ArrayList<Student> students = new ArrayList<Student>();
	StudentCatalogue studentList;

	
	@BeforeEach
	void setUp() {
		students = new ArrayList<Student>();
		students.add(new Student("Ola", 1, "BOY"));
		students.add(new Student("Anne", 2, "GIRL"));
		students.add(new Student("Per", 3, "BOY"));
		students.add(new Student("Lise", 4, "GIRL"));
		studentList = new StudentCatalogue(students);
	}
	
	@Test //checks that initially all students are in both courses
	void testStudentCatalogue() {
		for(Student s : students) {
			assertTrue(studentList.isINF101Student(s));
			assertTrue(studentList.isINF101Student(s));
		}
	}

	@Test //this tests that the lecturer is not a student
	void testLecturerIsNotStudent() {
		Student me = new Student("Martin Vatshelle",99,"BOY");
		assertFalse(studentList.isINF101Student(me));
		assertFalse(studentList.isINF102Student(me));
	}

	@Test
	void testAddStudent() {
		Student newStudent = new Student("Greta Thunberg",99,"GIRL");
		assertFalse(studentList.isINF101Student(newStudent));
		assertFalse(studentList.isINF102Student(newStudent));
		studentList.addInf101Student(newStudent);
		assertTrue(studentList.isINF101Student(newStudent));
		assertFalse(studentList.isINF102Student(newStudent));
		studentList.addInf102Student(newStudent);
		assertTrue(studentList.isINF101Student(newStudent));
		assertTrue(studentList.isINF102Student(newStudent));
	}

	@Test
	void testRemoveINF101Student() {
		Student leavingStudent = students.get(3);
		assertTrue(studentList.isINF101Student(leavingStudent));
		studentList.removeInf101Student(leavingStudent);
		assertFalse(studentList.isINF101Student(leavingStudent));
		assertTrue(studentList.isINF102Student(leavingStudent));
	}

	@Test
	void testRemoveInf102Student() {
		Student leavingStudent = students.get(3);
		assertTrue(studentList.isINF102Student(leavingStudent));
		studentList.removeInf102Student(leavingStudent);
		assertFalse(studentList.isINF102Student(leavingStudent));
		assertTrue(studentList.isINF101Student(leavingStudent));
	}
	
}
