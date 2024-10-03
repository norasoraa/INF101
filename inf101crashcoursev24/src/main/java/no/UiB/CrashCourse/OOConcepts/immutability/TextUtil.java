package no.UiB.CrashCourse.OOConcepts.immutability;

public class TextUtil {
    
    private final StringBuilder text; // StringBuilder is mutable, so this class is not immutable

    public TextUtil() {
        text = new StringBuilder("Hello World!");
    }

    public StringBuilder getText() {
        return text;
    }
}

