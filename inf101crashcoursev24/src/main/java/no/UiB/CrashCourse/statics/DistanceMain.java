package no.UiB.CrashCourse.statics;

public class DistanceMain {
    
    public static void main(String[] args) {
        Coordinate c1 = new Coordinate(0, 0);
        Coordinate c2 = new Coordinate(3, 4);
        
        System.out.println("Distance between c1 and c2: " + DistanceCalculator.calculateDistance(c1, c2));
    }
}
