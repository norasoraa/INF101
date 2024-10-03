package no.UiB.CrashCourse.statics;


public class DistanceCalculator {
    
    public static double calculateDistance(Coordinate c1, Coordinate c2) {
        return Math.sqrt(Math.pow(c2.x() - c1.x(), 2) + Math.pow(c2.y() - c1.y(), 2));
    }
}
