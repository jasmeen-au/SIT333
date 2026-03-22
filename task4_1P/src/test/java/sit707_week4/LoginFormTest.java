package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 */
public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "225142581"; // <-- put your ID
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Jasmeen"; // <-- put your name
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	// TC1
	@Test
	public void testEmptyUsernameAndPassword() {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Empty Username", status.getErrorMsg());
	}

	// TC2
	@Test
	public void testEmptyUsernameWrongPassword() {
		LoginStatus status = LoginForm.login(null, "xyz");
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Empty Username", status.getErrorMsg());
	}

	// TC3
	@Test
	public void testEmptyUsernameCorrectPassword() {
		LoginStatus status = LoginForm.login(null, "ahsan_pass");
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Empty Username", status.getErrorMsg());
	}

	// TC4
	@Test
	public void testWrongUsernameEmptyPassword() {
		LoginStatus status = LoginForm.login("abc", null);
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Empty Password", status.getErrorMsg());
	}

	// TC5
	@Test
	public void testWrongUsernameWrongPassword() {
		LoginStatus status = LoginForm.login("abc", "xyz");
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Credential mismatch", status.getErrorMsg());
	}

	// TC6
	@Test
	public void testWrongUsernameCorrectPassword() {
		LoginStatus status = LoginForm.login("abc", "ahsan_pass");
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Credential mismatch", status.getErrorMsg());
	}

	// TC7
	@Test
	public void testCorrectUsernameEmptyPassword() {
		LoginStatus status = LoginForm.login("ahsan", null);
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Empty Password", status.getErrorMsg());
	}

	// TC8
	@Test
	public void testCorrectUsernameWrongPassword() {
		LoginStatus status = LoginForm.login("ahsan", "xyz");
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Credential mismatch", status.getErrorMsg());
	}

	// TC9 (Login success)
	@Test
	public void testValidLogin() {
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		Assert.assertTrue(status.isLoginSuccess());
		Assert.assertNotNull(status.getErrorMsg()); // validation code
	}

	// TC10 (Invalid validation code)
	@Test
	public void testInvalidValidationCode() {
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		Assert.assertTrue(status.isLoginSuccess());

		boolean result = LoginForm.validateCode("wrong_code");
		Assert.assertFalse(result);
	}

	// TC11 (Valid validation code)
	@Test
	public void testValidValidationCode() {
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		Assert.assertTrue(status.isLoginSuccess());

		boolean result = LoginForm.validateCode(status.getErrorMsg());
		Assert.assertTrue(result);
	}
}