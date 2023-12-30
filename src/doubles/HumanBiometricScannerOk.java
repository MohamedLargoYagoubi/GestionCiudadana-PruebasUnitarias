package doubles;

import data.SingleBiometricData;
import evoting.biometricdataperipheral.HumanBiometricScanner;
import exceptions.HumanBiometricScanningException;

public class HumanBiometricScannerOk implements HumanBiometricScanner {

    @Override
    public SingleBiometricData scanFaceBiometrics() throws HumanBiometricScanningException {

        try {
            return new SingleBiometricData(new byte[10]);
        } catch (Exception e) {
            throw new HumanBiometricScanningException("Datos faciales incorrectos");
        }
    }

    @Override
    public SingleBiometricData scanFingerprintBiometrics() throws HumanBiometricScanningException {
        try {
            return new SingleBiometricData(new byte[10]);
        } catch (Exception e) {
            throw new HumanBiometricScanningException("Datos dactilares incorrectos");
        }
    }
}
