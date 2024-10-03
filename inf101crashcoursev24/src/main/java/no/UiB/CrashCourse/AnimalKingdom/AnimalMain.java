package no.UiB.CrashCourse.AnimalKingdom;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class for the Animal Kingdom. Here you can test polymorphism.
 */
public class AnimalMain {
    
    public static void main(String[] args) {
        Animal cat = new Cat("Kitty");
        Animal dog = new Dog("Rex");
        Animal platypus = new Platypus("Perry");
        // Animal sheep = new Sheep("Dolly");
        
        List<Animal> animals = new ArrayList<>();
        animals.add(cat);
        animals.add(dog);
        animals.add(platypus);
        //animals.add(sheep);

        for (Animal animal : animals) {
            System.out.println(animal.getName() + " says " + animal.makeSound());
        }
        
    }
}
