package tests;

import entity.User;

public class Preconditions extends BaseTest {

    public static User userWithEmptyUsername = User.builder()
            .username("")
            .password(PASSWORD)
            .build();
}
