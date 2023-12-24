package evoting.biometricdataperipheral;

// Importamos únicamente las excepciones y las clases de paquete data que vayamos a utilizar
import data.BiometricData;
import data.Nif;
import exceptions.NotValidPassportException;
import exceptions.PassportBiometricReadingException;

public interface PassportBiometricReader { // Perip. for reading passport biometrics
    void validatePassport () throws NotValidPassportException;
    Nif getNifWithOCR ();
    BiometricData getPassportBiometricData () throws PassportBiometricReadingException;
}