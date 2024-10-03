package no.UiB.CrashCourse.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoxTest {

    Box<Toy> toyBox;

    @BeforeEach
    public void setUp() {
        toyBox = new Box<Toy>();
    }

    @Test
    public void testAdd() {
        Toy toyCar = new Toy("Car");
        Toy toyDoll = new Toy("Doll");
        Toy toyTrain = new Toy("Train");
        toyBox.add(toyCar);
        toyBox.add(toyDoll);
        toyBox.add(toyTrain);
        assertEquals(3, toyBox.contents.size());
    }

}
