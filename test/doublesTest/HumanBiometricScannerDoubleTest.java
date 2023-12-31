import doubles.HumanBiometricScannerIncorrect;
import doubles.HumanBiometricScannerIncorrectFace;
import doubles.HumanBiometricScannerIncorrectFinger;
import doubles.HumanBiometricScannerOk;
import exceptions.HumanBiometricScanningException;
import interfaces.HumanBiometricScannerInterfaceTest;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class HumanBiometricScannerDoubleTest implements HumanBiometricScannerInterfaceTest {

    HumanBiometricScannerOk hbsOk;
    HumanBiometricScannerIncorrectFinger hbsIncorrectFinger;
    HumanBiometricScannerIncorrectFace hbsIncorrectFace;
    HumanBiometricScannerIncorrect hbsIncorrect;


    @BeforeEach
    public void setUp() {
        hbsOk = new HumanBiometricScannerOk();
        hbsIncorrectFinger = new HumanBiometricScannerIncorrectFinger();
        hbsIncorrectFace = new HumanBiometricScannerIncorrectFace();
        hbsIncorrect = new HumanBiometricScannerIncorrect();
    }

    @Override
    public void scanBiometricOkTest() throws HumanBiometricScanningException {
        assertEquals(hbsOk.scanFaceBiometrics().getKeyData().length,hbsOk.scanFingerprintBiometrics().getKeyData().length);
        assertDoesNotThrow(() -> hbsOk);
    }

    @Override
    public void incorrectScanFaceBiometricTest() throws HumanBiometricScanningException {
        assertThrows(HumanBiometricScanningException.class, () -> hbsIncorrectFace.scanFaceBiometrics());
        assertThrows(HumanBiometricScanningException.class, () -> hbsIncorrect.scanFaceBiometrics());
        assertDoesNotThrow(() -> hbsOk.scanFaceBiometrics());
        assertDoesNotThrow(() -> hbsIncorrectFace.scanFingerprintBiometrics());
    }

    @Override
    public void incorrectScanFingerprintBiometricTest() throws HumanBiometricScanningException {
        assertThrows(HumanBiometricScanningException.class, () -> hbsIncorrect.scanFingerprintBiometrics());
        assertThrows(HumanBiometricScanningException.class, () -> hbsIncorrectFinger.scanFingerprintBiometrics());
        assertDoesNotThrow(() -> hbsOk.scanFingerprintBiometrics());
        assertDoesNotThrow(() -> hbsIncorrectFinger.scanFaceBiometrics());
    }
}
