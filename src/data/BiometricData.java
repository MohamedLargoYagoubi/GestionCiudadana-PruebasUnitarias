package data;

import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BiometricData that = (BiometricData) o;
        return Objects.equals(faceBiometricData, that.faceBiometricData) && Objects.equals(fingerprintBiometricData, that.fingerprintBiometricData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faceBiometricData, fingerprintBiometricData);
    }

    @Override
    public String toString() {
        return "BiometricData{" +
                "faceBiometricData=" + faceBiometricData +
                ", fingerprintBiometricData=" + fingerprintBiometricData +
                '}';
    }

}