package tests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLoginErrors extends BaseTest {

    @Test
    public void testLoginErrors() {
        openUrl("https://ok.ru");
        Assertions.assertEquals("https://ok.ru", getDriver().getCurrentUrl(), "адрес не совпал с ожидаемым");
    }
}
