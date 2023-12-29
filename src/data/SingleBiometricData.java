package data;

import java.util.Arrays;

public class SingleBiometricData {

    private final byte[] keyData;

    public SingleBiometricData(byte[] keyData) {
        if(keyData == null) throw new NullPointerException("The Key data can't be null");
        this.keyData = keyData;
    }

    public byte[] getKeyData() {
        return keyData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleBiometricData that = (SingleBiometricData) o;
        return Arrays.equals(keyData, that.keyData);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(keyData);
    }

    @Override
    public String toString() {
        return "SingleBiometricData{" +
                "KeyData=" + Arrays.toString(keyData) +
                '}';
    }
}