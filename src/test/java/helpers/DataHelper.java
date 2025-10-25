package helpers;

import lombok.Value;

public class DataHelper {

    private DataHelper() {
    }

    public static AuthInfo getAuthInfo() {
        var id = SqlHelper.getUserId();
        var login = SqlHelper.getUserLogin();
        var password = SqlHelper.getUserPassword();

        return new AuthInfo(id, login, password);
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        var code = SqlHelper.getLastAuthCode(authInfo.getId());
        return new VerificationCode(code);
    }

    @Value
    public static class AuthInfo {
        String id;
        String login;
        String password;
    }

    @Value
    public static class VerificationCode {
        String code;
    }
}