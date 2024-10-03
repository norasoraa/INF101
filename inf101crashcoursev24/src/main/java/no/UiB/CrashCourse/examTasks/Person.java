package no.UiB.CrashCourse.examTasks;

public class Person {
    private String name;
    private int yearOfBirth;

    public Person(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return this.name;
    }

    public int getYearOfBirth() {
        return this.yearOfBirth;
    }
}

class Main {
    public static void main(String[] args) {
        Person x = new Person("Tor", 1999);
        Person y = new Person("To" + "r", 1999);
        System.out.println(x == y);
    }
}
