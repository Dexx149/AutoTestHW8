import helpers.DataHelper;
import helpers.SqlHelper;
import org.junit.jupiter.api.AfterAll;
import pages.DashboardPage;
import pages.LoginPage;
import org.junit.jupiter.api.Test;
import pages.VerificationPage;

import static com.codeborne.selenide.Selenide.open;

public class AuthTest {

    @AfterAll
    static void cleanDb() {
        SqlHelper.cleanDatabase();
    }

    @Test
    void shouldLogin() {
        open("http://localhost:9999");

        DataHelper.AuthInfo authInfo = DataHelper.getAuthInfo();

        LoginPage loginPage = new LoginPage();

        VerificationPage verificationPage = loginPage.loginWith(authInfo);
        DataHelper.VerificationCode verificationCode = DataHelper.getVerificationCodeFor(authInfo.getLogin());
        DashboardPage dashboardPage = verificationPage.verifyWith(verificationCode);

    }
}