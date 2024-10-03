package no.UiB.CrashCourse.generics;

import java.util.List;
import java.util.ArrayList;

/**
 * Example of a generic class
 */
public class Box<T> {
    
    List<T> contents;

    /**
     * A box can contain anything
     */
    public Box() {
        contents = new ArrayList<T>();
    }

    /**
     * Put something in the box
     * @param thing to put in the box
     */
    public void add(T thing) {
        contents.add(thing);
    }

    public void remove(T thing) {
        contents.remove(thing);
    }
}
