package data;

public class BiometricData {

    private final SingleBiometricData faceBiometricData;
    private final SingleBiometricData fingerprintBiometricData;


    public BiometricData(SingleBiometricData faceBiometricData, SingleBiometricData fingerprintBiometricData) {
        this.faceBiometricData = faceBiometricData;
        this.fingerprintBiometricData = fingerprintBiometricData;
    }

    public SingleBiometricData getFaceBiometricData() {
        return faceBiometricData;
    }

    public SingleBiometricData getFingerprintBiometricData() {
        return fingerprintBiometricData;
    }
}
