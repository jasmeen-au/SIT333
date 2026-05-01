package web.service;

/**
 * Business logic to handle login functions.
 * 
 * @author Ahsan.
 */
public class LoginService {

    /**
     * Static method returns true for successful login, false otherwise.
     * @param username
     * @param password
     * @param dob
     * @return
     */
    public static boolean login(String username, String password, String dob) {

        // Check for null values
        if (username == null || password == null || dob == null) {
            return false;
        }

        // Check for empty values
        if (username.isEmpty() || password.isEmpty() || dob.isEmpty()) {
            return false;
        }

        // Define correct credentials
        String correctUsername = "ahsan";
        String correctPassword = "ahsan_pass";
        String correctDob = "2000-01-01";

        // Validate all three inputs
        if (username.equals(correctUsername) &&
            password.equals(correctPassword) &&
            dob.equals(correctDob)) {
            return true;
        }

        return false;
    }
}