package interfaces;

import doubles.PassportBiometricReaderIncorrect;
import exceptions.NotValidPassportException;
import exceptions.PassportBiometricReadingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public interface PassportBiometricReaderInterfaceTest {
    @Test
    void validPassaportTest();

    @Test
    void validGetPassaportBiometricDataTest();

    @Test
    void invalidPassaportTest() throws NotValidPassportException;

    @Test
    void incorrectBiometricDataPassaportTest() throws PassportBiometricReadingException;

    @Test
    void checkNifOrcTest();

}
