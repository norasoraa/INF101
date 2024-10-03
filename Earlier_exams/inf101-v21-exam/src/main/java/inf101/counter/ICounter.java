package inf101.counter;

/** Interface that describes what a counter can do. */
public interface ICounter {

    /** Gets the current whole number. */
    int getNumber();

    /** Increases the counter with 1. */
    void increaseCounter();

    /** Resets the counter to 0. */
    void resetCounter();
}
