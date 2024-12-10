package oncall.infrastructure.constants;

public enum Message {
    NEW_LINE("\n"),
    ;

    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
