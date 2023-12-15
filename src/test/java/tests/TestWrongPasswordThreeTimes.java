package tests;

import core.BaseTest;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.RecoveryPhoneCode;
import pages.RestorePasswordPage;
import pages.RecoveryStartPhoneLink;

import java.util.Random;

public class TestWrongPasswordThreeTimes extends BaseTest {

    public String LOGIN = RandomStringUtils.randomAlphabetic(7);

    @Test
    public void testWrongPasswordThreeTimes() {
        openUrl("https://ok.ru");
        Assertions.assertEquals("https://ok.ru/", getDriver().getCurrentUrl(), "адрес не совпал с ожидаемым");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterLoginText(LOGIN);
        for (int i = 0; i < 3; i++) {
            String PASSWORD = RandomStringUtils.randomAlphabetic(7);
            loginPage.enterPasswordText(PASSWORD).clickLoginButtonWithError();
        }
        Assertions.assertEquals("Кажется, что вы не можете ввести правильный логин или пароль.", loginPage.wrongLoginPasswordPage(), "отобразилась неверная ошибка");

        RecoveryStartPhoneLink recoveryStartPhoneLink = loginPage.restorePassword().clickPhoneLink();
        String countryCodeInList = recoveryStartPhoneLink.countryListInput();
        String codeInPhoneField = recoveryStartPhoneLink.phoneField();
        String countryFromList = recoveryStartPhoneLink.countryListwithName("Алжир");
        Assertions.assertEquals(countryCodeInList, codeInPhoneField, "отобразился неверный код");

        RecoveryStartPhoneLink recoveryPhoneCode = new RecoveryStartPhoneLink(getDriver());
        String PHONE_RECOVERY = RandomStringUtils.randomNumeric(9);
        recoveryPhoneCode.enterPhoneRecovery(PHONE_RECOVERY).getCode();

        // RestorePasswordPage restorePasswordPage = new RestorePasswordPage(getDriver());
        // restorePasswordPage.clickPhoneLink();
        // RecoveryStartPhoneLink recoveryStartPhoneLink = new RecoveryStartPhoneLink(getDriver());

        // recoveryStartPhoneLink.enterPhoneRecovery(PHONE_RECOVERY);

        // recoveryStartPhoneLink.countryListInput();
        // recoveryStartPhoneLink.getCode();
    }
}
