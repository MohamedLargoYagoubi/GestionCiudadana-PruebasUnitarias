import data.Nif;
import doubles.PassportBiometricReaderIncorrect;
import doubles.PassportBiometricReaderOk;
import exceptions.NotValidPassportException;
import exceptions.PassportBiometricReadingException;
import interfaces.PassportBiometricReaderInterfaceTest;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class PassportBiometricReaderDoubleTest implements PassportBiometricReaderInterfaceTest {

    PassportBiometricReaderOk pbrOk;
    PassportBiometricReaderIncorrect pbrIncorrect;
    Nif nif;

    @BeforeEach
    public void setUp() {
        pbrOk = new PassportBiometricReaderOk();
        pbrIncorrect = new PassportBiometricReaderIncorrect();
        nif = pbrOk.getNifWithOCR();
    }
    @Override
    public void validPassaportTest() {
        assertDoesNotThrow(() -> pbrOk.validatePassport());
    }

    @Override
    public void validGetPassaportBiometricDataTest() {
        assertDoesNotThrow(() -> pbrOk.getPassportBiometricData());
    }

    @Override
    public void invalidPassaportTest() throws NotValidPassportException {
        assertThrows(NotValidPassportException.class, () -> pbrIncorrect.validatePassport());
    }

    @Override
    public void incorrectBiometricDataPassaportTest() throws PassportBiometricReadingException {
        assertThrows(PassportBiometricReadingException.class, () -> pbrIncorrect.getPassportBiometricData());
    }

    @Override
    public void checkNifOrcTest() {
        assertTrue(nif.isValidNIF(nif.getNif()));
    }
}
