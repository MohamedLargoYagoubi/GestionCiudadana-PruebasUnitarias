package doubles;

import data.BiometricData;
import data.Nif;
import data.SingleBiometricData;
import evoting.biometricdataperipheral.PassportBiometricReader;
import exceptions.NotValidPassportException;
import exceptions.PassportBiometricReadingException;

public class PassportBiometricReaderOk implements PassportBiometricReader {
    BiometricData passpBD;
    Nif nif;
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
        //check nif
        if(nif.isValidNIF(nif.getNif())) return nif;
        return null;
    }

    @Override
    public BiometricData getPassportBiometricData() throws PassportBiometricReadingException {
        if (passpBD == null) throw new PassportBiometricReadingException("Error en la lectura del passaporte ");
        return new BiometricData(new SingleBiometricData(new byte[10]), new SingleBiometricData(new byte[10]));
    }
}
