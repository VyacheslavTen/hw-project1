package tests;

import core.BaseTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class TestSupportAppeal extends BaseTest {

    public String LOGIN = RandomStringUtils.randomAlphabetic(7);

    @Test
    public void testSupportAppeal() {
        openUrl("https://ok.ru");
        Assertions.assertEquals("https://ok.ru/", getDriver().getCurrentUrl(), "адрес не совпал с ожидаемым");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterLoginText(LOGIN);
        for (int i = 0; i < 3; i++) {
            String PASSWORD = RandomStringUtils.randomAlphabetic(7);
            loginPage.enterPasswordText(PASSWORD).clickLoginButtonWithError();

        }

        loginPage.restorePassword().clickSupportLink().switchToSupportChat().clickSupportLoginPasswordButton();

    }
}
