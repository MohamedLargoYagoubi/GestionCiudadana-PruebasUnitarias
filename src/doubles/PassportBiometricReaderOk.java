package doubles;

import data.BiometricData;
import data.Nif;
import evoting.biometricdataperipheral.PassportBiometricReader;
import exceptions.NotValidPassportException;
import exceptions.PassportBiometricReadingException;

public class PassportBiometricReaderOk implements PassportBiometricReader {
    @Override
    public void validatePassport() throws NotValidPassportException {

    }

    @Override
    public Nif getNifWithOCR() {
        return null;
    }

    @Override
    public BiometricData getPassportBiometricData() throws PassportBiometricReadingException {
        return null;
    }
}
