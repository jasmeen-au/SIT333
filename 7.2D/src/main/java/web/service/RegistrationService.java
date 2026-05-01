package web.service;

/**
 * Business logic to handle registration functions.
 * 
 * @author Ahsan.
 */
public class RegistrationService {

    public static boolean register(String fName, String lName, String email, String dob) {

        if (fName == null || lName == null || email == null || dob == null) {
            return false;
        }

        if (fName.isEmpty() || lName.isEmpty() || email.isEmpty() || dob.isEmpty()) {
            return false;
        }

        if (!email.contains("@") || !email.contains(".")) {
            return false;
        }

        if (fName.length() < 2 || lName.length() < 2) {
            return false;
        }

        return true;
    }
}