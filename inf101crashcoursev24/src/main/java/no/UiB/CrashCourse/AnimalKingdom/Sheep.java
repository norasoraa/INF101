package no.UiB.CrashCourse.AnimalKingdom;

/**
 * This is a Sheep! Baaah!
 */
public class Sheep implements Animal{

    private static final String breed = "Sheep";
    private String name = breed;

    public Sheep(String name) {
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
