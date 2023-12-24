package data;

import java.util.Arrays;

public class SingleBiometricData {

    private final byte[] KeyData;

    public SingleBiometricData(byte[] keyData) {
        if(keyData == null) throw new NullPointerException("The Key data can't be null");
        this.KeyData = keyData;
    }

    public byte[] getKeyData() {
        return KeyData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleBiometricData that = (SingleBiometricData) o;
        return Arrays.equals(KeyData, that.KeyData);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(KeyData);
    }

    @Override
    public String toString() {
        return "SingleBiometricData{" +
                "KeyData=" + Arrays.toString(KeyData) +
                '}';
    }
}
