

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class MainApplicationTest {

    private SimpleClassExample mainApp;

    public MainApplicationTest() {
        mainApp = new SimpleClassExample();
    }

    @Test
    public void test1() {
        Assertions.assertTrue(mainApp.isEmailValid("fred@gmail.com"));
    }

    @Test
    public void test2() {
        Assertions.assertFalse(mainApp.isEmailValid("fred.com"));
    }

    @ParameterizedTest
    @CsvSource({"devin@gmail.com", "tori@hotmail.com", "tofu@gmail.com", "jim@wow.com"})
    public void emailShouldAllPass(String email) {
        Assertions.assertTrue(mainApp.isEmailValid(email));
    }

    @ParameterizedTest
    @CsvSource({"devin@gmailcom", "torihotmai.com", "@gmail.com", "jim@com@"})
    public void emailShouldAllFail(String email) {
        Assertions.assertFalse(mainApp.isEmailValid(email));
    }

    @ParameterizedTest
    @CsvSource({"2485053913", "248-505-3913", "2495053913", "248.505.3913","248.505.3913"})
    public void phoneShouldAllPass(String phone) {
        Assertions.assertTrue(mainApp.isPhoneValid(phone));
    }

    @ParameterizedTest
    @CsvSource({"24850539130", "248053913", "2485dd053913", "24850253913","248  505913"})
    public void phoneShouldAllFail(String phone) {
        Assertions.assertFalse(mainApp.isPhoneValid(phone));
    }
}
