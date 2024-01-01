import data.BiometricData;
import data.Nif;
import data.SingleBiometricData;
import doubles.PassportBiometricReaderIncorrect;
import doubles.PassportBiometricReaderOk;
import doublesTest.interfaces.PassportBiometricReaderInterfaceTest;
import exceptions.InvalidNifException;
import exceptions.NotValidPassportException;
import exceptions.PassportBiometricReadingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PassportBiometricReaderDoubleTest implements PassportBiometricReaderInterfaceTest {

    PassportBiometricReaderOk pbrOk;
    BiometricData passpBD;
    PassportBiometricReaderIncorrect pbrIncorrect;
    Nif nif;

    @BeforeEach
    public void setUp() throws InvalidNifException {
        nif = new Nif("12345678Z");
        passpBD = new BiometricData(new SingleBiometricData(new byte [10]),new SingleBiometricData(new byte[10]));
        pbrOk = new PassportBiometricReaderOk(passpBD,nif);
        pbrIncorrect = new PassportBiometricReaderIncorrect();
    }
    @Override
    @Test
    public void validPassaportTest() {
        assertDoesNotThrow(() -> pbrOk.validatePassport());
    }

    @Override
    @Test
    public void validGetPassaportBiometricDataTest() {
        assertDoesNotThrow(() -> pbrOk.getPassportBiometricData());
    }

    @Override
    @Test
    public void invalidPassaportTest() throws NotValidPassportException {
        assertThrows(NotValidPassportException.class, () -> pbrIncorrect.validatePassport());
    }

    @Override
    @Test
    public void incorrectBiometricDataPassaportTest() throws PassportBiometricReadingException {
        assertThrows(PassportBiometricReadingException.class, () -> pbrIncorrect.getPassportBiometricData());
    }

    @Override
    @Test
    public void checkNifOrcTest() {
        assertTrue(nif.isValidNIF(nif.getNif()));
    }
}
