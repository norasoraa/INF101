package no.UiB.CrashCourse.generics;

public class GenericMain {

    public static void main(String[] args) {
        Toy toyCar = new Toy("Car");
        Toy toyDoll = new Toy("Doll");
        Toy toyTrain = new Toy("Train");

        Box<Toy> toyBox = new Box<Toy>();
        toyBox.add(toyCar);
        toyBox.add(toyDoll);
        toyBox.add(toyTrain);
    }
    
}