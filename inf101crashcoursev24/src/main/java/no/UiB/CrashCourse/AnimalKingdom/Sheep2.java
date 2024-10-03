package no.UiB.CrashCourse.AnimalKingdom;

/**
 * This is a Sheep! Baaah!
 */
public class Sheep2 extends Mammal {

    private static final String breed = "Sheep";
    private String name = breed;

    public Sheep2(String name) {
        this.name = name;
    }

    @Override
    public String makeSound() {
        return "Baaah";
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getName() {
        return name;
    }
}
