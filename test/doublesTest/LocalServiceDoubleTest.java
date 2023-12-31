import data.Password;
import doubles.LocalServiceOk;
import doublesTest.interfaces.LocalServiceInterfaceTest;
import exceptions.InvalidAccountException;
import exceptions.InvalidPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LocalServiceDoubleTest implements LocalServiceInterfaceTest {

   LocalServiceOk loclaserviceOk;
   Map<Password, String> userCredentials;
   Password validpssw;
   Password validpssw1;
   @BeforeEach
   public void setUp() throws InvalidPasswordException {
       userCredentials = new HashMap<>();
       validpssw = new Password("123456789");
       validpssw1 = new Password("abcdefLKXYK199");
       userCredentials.put(validpssw,"Valid user 1");
       userCredentials.put(validpssw1, "Valid user 2");
       userCredentials.put(new Password(null), "Invalid user");
       loclaserviceOk = new LocalServiceOk(userCredentials);
   }

    @Override
    @Test
    public void verifyAccountValidAccessTest() {
        assertDoesNotThrow(() -> loclaserviceOk.verifyAccount(userCredentials.get(validpssw),validpssw));
        assertDoesNotThrow(() -> loclaserviceOk.verifyAccount(userCredentials.get(validpssw1),validpssw1));
    }

    @Override
    @Test
    public void verifyAccountInvalidPasswordTest() throws InvalidAccountException {
        assertThrows(InvalidAccountException.class, () -> loclaserviceOk.verifyAccount("Invalid user", null));
    }

    @Override
    @Test
    public void verifyAccountInvalidLoginTest() throws InvalidAccountException {
        assertThrows(InvalidAccountException.class, () -> loclaserviceOk.verifyAccount(null, null));
    }
}
