package doubles;

import data.SingleBiometricData;
import evoting.biometricdataperipheral.HumanBiometricScanner;
import exceptions.HumanBiometricScanningException;

public class HumanBiometricScannerIncorrect implements HumanBiometricScanner {
    @Override
    public SingleBiometricData scanFaceBiometrics() throws HumanBiometricScanningException {
        throw new HumanBiometricScanningException("Datos faciales incorrectos");
    }

    @Override
    public SingleBiometricData scanFingerprintBiometrics() throws HumanBiometricScanningException {
        throw new HumanBiometricScanningException("Datos dactilares incorrectos");
    }
}
