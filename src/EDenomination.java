public enum EDenomination {
    TWENTY(20),
    TEN(10),
    FIVE(5),
    TWO(2),
    ONE(1);

    private final int value;

    EDenomination(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
