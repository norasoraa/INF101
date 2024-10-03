package inf101.pair;

/** Class that represents a pair of Integers. */
public class Pair implements IIntegerPair {

    private final int first;
    private final int second;

    /** Constructs a new pair with the two given integers. */
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public Integer getFirst() {
        return first;
    }

    @Override
    public Integer getSecond() {
        return second;
    }

    @Override
    public int sumOfPair() {
        return first + second;
    }

}
