package helpers;

import lombok.Value;

public class DataHelper {

    private DataHelper() {
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }
    public static VerificationCode getVerificationCodeFor(String login) {
        var code = SqlHelper.getLastAuthCode(login);
        if (code == null) {
            throw new RuntimeException("No auth code found for user: " + login);
        }
        return new VerificationCode(code);
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    @Value
    public static class VerificationCode {
        String code;
    }
}