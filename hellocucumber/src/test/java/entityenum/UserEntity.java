package entityenum;

import static utils.EmailGenerator.generateRandomEmail;

public enum UserEntity {
    NAME("name"),
    LAST_NAME("surname"),
    EMAIL(generateRandomEmail()),
    PASSWORD("UserPassword1!"),
    REPEAT_PASSWORD("UserPassword1!");

    private final String fieldName;

    UserEntity(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
