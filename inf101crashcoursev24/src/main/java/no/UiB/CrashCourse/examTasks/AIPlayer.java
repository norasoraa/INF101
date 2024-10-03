package no.UiB.CrashCourse.examTasks;

public class AIPlayer {
    private String name = "AIPlayer";
    public void talk() {
        System.out.println("I am a robot brrrr");
    }
    @Override
    public String toString() {
        return name;
    } 
}

class AIPlayerMain {
    public static void main(String[] args) {
        AIPlayer ai = new AIPlayer();
        ai.talk();
        System.out.println(ai);
    }
}