package no.UiB.CrashCourse.OOConcepts.immutability;

public class Outsiders {
    
    public static void main(String[] args) {
        TextUtil util = new TextUtil();

        StringBuilder text = util.getText();

        text.append(" Goodbye World!"); //!
    }
}
