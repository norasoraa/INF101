package no.UiB.CrashCourse.OOConcepts.encapsulation;

public class Text implements ReadOnlyText{
    
    private String content;

    public Text(String content) {
        this.content = content;
    }

    @Override
    public String read() {
        return content;
    }

    public void write(String content) {
        this.content = content;
    }
}
