package no.UiB.CrashCourse.OOConcepts.encapsulation;

public class TextMain {
    

    public static void main(String[] args) {
        ReadOnlyText text = new Text("Hello World");
        System.out.println(text.read());
        // text.write("Hello Universe");
    }
}
