package tests;

import entity.User;

public class Preconditions extends BaseTest {

    public static User userWithEmptyUsername = User.builder()
            .username("")
            .password(PASSWORD)
            .build();

    public static User userWithEmptyPassword = User.builder()
            .username("")
            .password(PASSWORD)
            .build();

    public static User userWithEmptyUsernameAndPassword = User.builder()
            .username("")
            .password("")
            .build();

    public static User userWithIncorrectData = User.builder()
            .username("sefse")
            .password("fdsdsf")
            .build();

    public static User userWithCorrectData = User.builder()
            .username(USERNAME)
            .password(PASSWORD)
            .build();
}
