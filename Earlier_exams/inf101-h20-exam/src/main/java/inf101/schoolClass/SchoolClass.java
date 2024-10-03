package inf101.schoolClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class represents a School Class.
 * The school class consists of students which are either boys or girls.
 * Students are described by the type {@link Student}.
 */
public class SchoolClass implements ISchoolClass {

    private String className;
    private List<Student> students;

    /**
     * Constructs a new School Class with the given name. The class is represented
     * as an empty {@link List}, use the method {@link #add()} to add students to
     * the class.
     * 
     * @param className the name of the class
     */
    public SchoolClass(String className) {
        this.className = className;
        students = new ArrayList<>();
    }

    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public int countGirls() {
        int count = 0;
        for (Student student : students) {
            if (student.isGirl()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int countBoys() {
        return students.size() - countGirls();
    }

    @Override
    public void add(Student student) {
        if (students.contains(student)) {
            throw new IllegalArgumentException("The student is already in the class.");
        } else if (student == null) {
            throw new NullPointerException();
        }
        students.add(student);
    }

}
