package no.UiB.CrashCourse.AnimalKingdom;

/**
 * Class for dogs., extends Mammal.
 */
public class Dog extends Mammal {

    private static final String breed = "Dog";
    private String name = breed;

    public Dog(String name) {
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
        return "Bark bark!";
    }
    
}
