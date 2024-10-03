package no.UiB.CrashCourse.AnimalKingdom;

/**
 * Class for Platypus, extends Mammal, but overrides laysEggs.
 */
public class Platypus extends Mammal {

    private static final String breed = "Platypus";
    private String name = breed;

    public Platypus(String name) {
        this.name = name;
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String makeSound() {
        return "*fart sounds*";
    }

    @Override
    public boolean laysEggs() {
        return true;
    }
}
