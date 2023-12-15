package tests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;




public class TestEmptyPasswordLoginFormError extends BaseTest {
    @Test
    public void testEmptyPasswordLoginFormError() {
        openUrl("https://ok.ru");
        Assertions.assertEquals("https://ok.ru/", getDriver().getCurrentUrl(), "адрес не совпал с ожидаемым");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterLoginText("login123");
        loginPage.clickLoginButtonWithError();

        Assertions.assertEquals("Введите пароль", loginPage.getErrorText(), "отобразилась неверная ошибка");
    }
}
