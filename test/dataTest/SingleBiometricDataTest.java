import data.SingleBiometricData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SingleBiometricDataTest {

    SingleBiometricData singlebiometricdata;

    @BeforeEach
    public void SetUp() {
        byte[] keyData = new byte[5];
        singlebiometricdata = new SingleBiometricData(keyData);
    }

    @Test
    public void getsingleBiometricDatatest() {
        byte[] keyData = new byte[5];
        assertArrayEquals(keyData, singlebiometricdata.getKeyData());
    }

    @Test
    public void nullDigitalSignatureTest() {
        assertThrows(NullPointerException.class, () -> new SingleBiometricData(null));
    }

    @Test
    public void differentKeyDatatest() {
        byte[] differentData = new byte[10];
        assertNotEquals(differentData,singlebiometricdata.getKeyData());
    }




}
