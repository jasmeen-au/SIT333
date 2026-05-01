package web.service;

import org.junit.Assert;
import org.junit.Test;

public class RegistrationServiceUnitTest {

    @Test
    public void testValidRegistration() {
        Assert.assertTrue(
            RegistrationService.register("John", "Doe", "john@gmail.com", "2000-01-01")
        );
    }

    @Test
    public void testEmptyFields() {
        Assert.assertFalse(
            RegistrationService.register("", "", "", "")
        );
    }

    @Test
    public void testInvalidEmail() {
        Assert.assertFalse(
            RegistrationService.register("John", "Doe", "wrongemail", "2000-01-01")
        );
    }

    @Test
    public void testNullInputs() {
        Assert.assertFalse(
            RegistrationService.register(null, null, null, null)
        );
    }

    @Test
    public void testShortName() {
        Assert.assertFalse(
            RegistrationService.register("J", "D", "john@gmail.com", "2000-01-01")
        );
    }
}