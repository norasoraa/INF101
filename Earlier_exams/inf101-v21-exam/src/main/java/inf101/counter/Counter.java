package inf101.counter;

/** Class that represents a counter. */
public class Counter implements ICounter {

    private int counter;

    /** Constructs a new counter with 0 as the start value. */
    public Counter() {
        this.counter = 0;
    }

    @Override
    public int getNumber() {
        return counter;
    }

    @Override
    public void increaseCounter() {
        counter++;
    }

    @Override
    public void resetCounter() {
        counter = 0;
    }

}
