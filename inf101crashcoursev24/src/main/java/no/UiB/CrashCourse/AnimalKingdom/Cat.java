package no.UiB.CrashCourse.AnimalKingdom;

/**
 * Class for cats., extends Mammal.
 */
public class Cat extends Mammal {

    private static final String breed = "Cat";
    private String name = breed;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String makeSound() {
        return "Meow meow!";
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
