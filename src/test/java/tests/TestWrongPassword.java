package tests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class TestWrongPassword extends BaseTest {
    @Test
    public void testWrongPassword() {
        openUrl("https://ok.ru");
        Assertions.assertEquals("https://ok.ru/", getDriver().getCurrentUrl(), "адрес не совпал с ожидаемым");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterLoginText("login123");
        loginPage.enterPasswordText("7498273jejt");
        loginPage.clickLoginButtonWithError();
        Assertions.assertEquals("Неправильно указан логин и/или пароль", loginPage.getErrorText(), "отобразилась неверная ошибка");
    }
}
