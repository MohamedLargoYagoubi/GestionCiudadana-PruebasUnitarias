package interfaces;

import exceptions.HumanBiometricScanningException;
import org.junit.jupiter.api.Test;

public interface HumanBiometricScannerInterfaceTest {

    @Test
    void scanBiometricOkTest() throws HumanBiometricScanningException;
    @Test
    void incorrectScanFaceBiometricTest() throws HumanBiometricScanningException;

    @Test
    void incorrectScanFingerprintBiometricTest() throws HumanBiometricScanningException;

}
