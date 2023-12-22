package tests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.RecoveryStratEmailLink;

public class TestWrongEmailInRestorePasswordPage extends BaseTest {
    @Test
    public void testWrongEmailInRestorePasswordPage() throws InterruptedException {
        openUrl("https://ok.ru");
        Assertions.assertEquals("https://ok.ru/", getDriver().getCurrentUrl(), "адрес не совпал с ожидаемым");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickRestoreLink().clickEmailLink();
        RecoveryStratEmailLink recoveryStratEmailLink = new RecoveryStratEmailLink(getDriver());
        recoveryStratEmailLink.clickReceiveCode();
        Thread.sleep(2000);
        Assertions.assertEquals("Неправильный формат почты", recoveryStratEmailLink.getError() ,"текст не совпал с ожидаемым");
    }
}
