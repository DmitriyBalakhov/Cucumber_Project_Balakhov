package entityfactory;

import entityenum.UserEntity;
import org.example.entity.User;
import org.example.entity.UserLoginData;
import org.example.entity.UsersProfileData;


public class UserFactory {

public static User createUser() {
return new User(
        UserEntity.NAME.getFieldName(),
        UserEntity.LAST_NAME.getFieldName(),
        UserEntity.EMAIL.getFieldName(),
        UserEntity.PASSWORD.getFieldName(),
        UserEntity.REPEAT_PASSWORD.getFieldName());
}

    public static UserLoginData loginUser() {
        return new UserLoginData(
                UserEntity.EMAIL.getFieldName(),
                "UserPassword1!",
                "false");
    }

    public static UsersProfileData updateUserProfile() {
        return new UsersProfileData(
                "Jack",
                "Black",
                "1990-01-01T01:01:01.000Z",
                "USA"
                );
    }

}
