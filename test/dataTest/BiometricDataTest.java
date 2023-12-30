import data.BiometricData;
import data.SingleBiometricData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BiometricDataTest {
    SingleBiometricData faceBiometricData;
    SingleBiometricData fingerprintBiometricData;
    BiometricData biometricData;

    @BeforeEach
    public void SetUp() {
        byte[] keyData = new byte[10];
        faceBiometricData = new SingleBiometricData(keyData);
        fingerprintBiometricData = new SingleBiometricData(keyData);
        biometricData = new BiometricData(faceBiometricData,fingerprintBiometricData);

    }
    @Test
    public void getBiometricDatatest() {
        assertEquals(faceBiometricData, biometricData.getFaceBiometricData());
        assertEquals(fingerprintBiometricData, biometricData.getFingerprintBiometricData());
    }

    @Test
    public void nullFaceDatatest() {
      BiometricData biometricnullFace = new BiometricData(null,fingerprintBiometricData);
        assertThrows(NullPointerException.class, () -> biometricnullFace.getFaceBiometricData().getKeyData());
    }

    @Test
    public void nullfingerDatatest() {
        BiometricData biometricnullFace = new BiometricData(faceBiometricData,null);
        assertThrows(NullPointerException.class, () -> biometricnullFace.getFingerprintBiometricData().getKeyData());
    }

    @Test
    public void nullBiometricDatatest() {
        BiometricData nullBiometricdata = new BiometricData(faceBiometricData,null);
        assertThrows(NullPointerException.class, () -> nullBiometricdata.getFingerprintBiometricData().getKeyData());
        assertThrows(NullPointerException.class, () -> nullBiometricdata.getFaceBiometricData().getKeyData());
    }

}
