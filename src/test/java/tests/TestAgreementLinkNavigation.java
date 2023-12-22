package tests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class TestAgreementLinkNavigation extends BaseTest {
    @Test
    public void testAgreementLinkNavigation() {
        openUrl("https://ok.ru");
        Assertions.assertEquals("https://ok.ru/", getDriver().getCurrentUrl(), "адрес не совпал с ожидаемым");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.hoverMoreButton().clickAgreementLink();
        Assertions.assertEquals("https://ok.ru/agreementpage", getDriver().getCurrentUrl(), "адрес не совпал с ожидаемым");
    }
}
