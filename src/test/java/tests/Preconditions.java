package tests;

import entity.User;

public class Preconditions extends BaseTest {

    protected final User userWithEmptyUsername = User.builder()
            .username("")
            .password(PASSWORD)
            .build();

    protected final User userWithEmptyPassword = User.builder()
            .username(USERNAME)
            .password("")
            .build();

    protected final User userWithEmptyUsernameAndPassword = User.builder()
            .username("")
            .password("")
            .build();

    protected final User userWithIncorrectData = User.builder()
            .username("sefse")
            .password("fdsdsf")
            .build();

    protected final User userWithCorrectData = User.builder()
            .username(USERNAME)
            .password(PASSWORD)
            .build();
}
