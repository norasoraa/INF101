package no.UiB.CrashCourse.AnimalKingdom;

/**
 * Abstract class for mammals. It is not possible to create an instance of this class.
 */
public abstract class Mammal implements Animal{
     
    public boolean laysEggs() {
        return false;
    }
}
