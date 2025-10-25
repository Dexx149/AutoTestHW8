package pages;

import com.codeborne.selenide.SelenideElement;
import helpers.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");

    public VerificationPage loginWith(DataHelper.AuthInfo authInfo) {
        loginField.setValue(authInfo.getLogin());
        passwordField.setValue("qwerty123");
        loginButton.click();
        return new VerificationPage();
    }
}