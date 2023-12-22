package tests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.RegistrationPage;

public class TestWrongRegistrationPhone extends BaseTest {
    @Test
    public void testWrongRegistrationPhone() throws InterruptedException {
        openUrl("https://ok.ru");
        Assertions.assertEquals("https://ok.ru/", getDriver().getCurrentUrl(), "адрес не совпал с ожидаемым");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickRegisterButton();
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        registrationPage.clickContinueButton();
        Thread.sleep(2000);
        Assertions.assertEquals("Неправильный номер телефона.", registrationPage.phoneErrorMessage(), "отобразилась неверная ошибка");
    }
}
