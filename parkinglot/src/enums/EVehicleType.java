package enums;

public enum EVehicleType {
    BIKE("BIKE"),
    CAR("CAR");

    private final String value;

    EVehicleType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
