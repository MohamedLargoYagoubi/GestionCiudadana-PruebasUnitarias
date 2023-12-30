package doubles;

import data.BiometricData;
import data.Nif;
import data.SingleBiometricData;
import evoting.biometricdataperipheral.PassportBiometricReader;
import exceptions.NotValidPassportException;
import exceptions.PassportBiometricReadingException;

public class PassportBiometricReaderIncorrect implements PassportBiometricReader {
    BiometricData passpBD;
    @Override
    public void validatePassport() throws NotValidPassportException {
        try {
            passpBD = getPassportBiometricData();
        } catch (Exception e) {
            throw new NotValidPassportException("El pasaporte no es valido");
        }
    }

    @Override
    public Nif getNifWithOCR() {
        return null;
    }

    @Override
    public BiometricData getPassportBiometricData() throws PassportBiometricReadingException {
        if (passpBD == null) throw new PassportBiometricReadingException("Error en la lectura del passaporte ");
        return null;
    }
}
