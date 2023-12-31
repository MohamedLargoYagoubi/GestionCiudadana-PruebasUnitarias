import data.Nif;
import data.Password;
import exceptions.InvalidNifException;
import exceptions.InvalidPasswordException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
public class PasswordDataTest {

    String nullPassword = null;
    String shortPassword = "1234";
    String longPassword = "1111111111111111111111111111111111111";
    String invalidCharForPassword = "12345678_";
    String invalidCharForPassword2 = "abcdeftg.";

    String correctPassword1 = "123456789";
    String correctPassword2 = "abcdefLKXYK199";


    @Nested
    @DisplayName("Se lanza InvalidPasswordException")
    class throwsException {
        @Test
        public void passwordNull() throws InvalidPasswordException {
            assertThrows(InvalidPasswordException.class, () -> new Password(nullPassword));
        }

        @Test
        public void passwordTooShort() throws InvalidPasswordException {
            assertThrows(InvalidPasswordException.class, () -> new Password(shortPassword));
        }

        @Test
        public void passwordTooLong() throws InvalidPasswordException {
            assertThrows(InvalidPasswordException.class, () -> new Password(longPassword));
        }

        @Test
        public void passwordWithInvalidChars() throws InvalidPasswordException {
            assertThrows(InvalidPasswordException.class, () -> new Password(invalidCharForPassword));
        }

        @Test
        public void passwordWithInvalidChars2() throws InvalidPasswordException {
            assertThrows(InvalidPasswordException.class, () -> new Password(invalidCharForPassword2));
        }
    }

    @Nested
    @DisplayName("No se lanza InvalidPasswordException")
    class doesNotThrowException {

        @Test
        public void passwordCorrect() {
            assertDoesNotThrow(() -> new Password(correctPassword1));
        }

        @Test
        public void passwordCorrect2() {
            assertDoesNotThrow(() -> new Password(correctPassword2));
        }
    }

    @Test
    public void checkPasswords() throws InvalidPasswordException {
        Password pass = new Password("123456789");
        assertEquals(pass.getPassword(), correctPassword1);
    }

    @Test
    public void checkPasswords2() throws InvalidPasswordException {
        assertNotEquals(correctPassword1,correctPassword2);
    }
    @Test
    public void checkString() throws InvalidPasswordException {
        Password cp1 = new Password(correctPassword1);
        String str = new String("Contraseña= {123456789'}");
        assertEquals(str, cp1.toString());
    }

}
