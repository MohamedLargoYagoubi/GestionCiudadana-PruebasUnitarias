package doublesTest.interfaces;

import exceptions.InvalidAccountException;
import org.junit.jupiter.api.Test;

public interface LocalServiceInterfaceTest {
    @Test
    void verifyAccountValidAccessTest();

    @Test
    void verifyAccountInvalidPasswordTest() throws InvalidAccountException;

    @Test
    void verifyAccountInvalidLoginTest() throws InvalidAccountException;
}
