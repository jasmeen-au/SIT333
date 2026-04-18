package web.service;
import org.junit.Assert;
import org.junit.Test;
import web.service.LoginService;

public class LoginServiceUnitTest {

    @Test
    public void testValidLogin() {
        Assert.assertTrue(LoginService.login("ahsan", "ahsan_pass", "2000-01-01"));
    }

    @Test
    public void testWrongPassword() {
        Assert.assertFalse(LoginService.login("ahsan", "wrong_pass", "2000-01-01"));
    }

    @Test
    public void testWrongUsername() {
        Assert.assertFalse(LoginService.login("wrong_user", "ahsan_pass", "2000-01-01"));
    }

    @Test
    public void testWrongDob() {
        Assert.assertFalse(LoginService.login("ahsan", "ahsan_pass", "1999-01-01"));
    }

    @Test
    public void testEmptyInputs() {
        Assert.assertFalse(LoginService.login("", "", ""));
    }

    @Test
    public void testNullInputs() {
        Assert.assertFalse(LoginService.login(null, null, null));
    }
}