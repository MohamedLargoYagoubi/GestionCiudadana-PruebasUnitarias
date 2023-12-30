import data.Nif;
import exceptions.InvalidNifException;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class NifDataTest {

    String correctNifDNI = "12345678Z";
    String correctNifNIE = "Y2345678Z";
    String wrongNifIncorrectLength = "123456783232Z";
    String wrongNifControlLetter = "12345678M";
    String wrongNifInvalidNIE = "X2345678Z";
    String wrongNifNullObject = null;

    @Nested
    @DisplayName("El constructor lanza InvalidNifException.")
    class throwsExceptions{
        @Test
        public void incorrectLength() throws InvalidNifException {
            assertThrows(InvalidNifException.class, () -> new Nif(wrongNifIncorrectLength));
        }

        @Test
        public void incorrectControlLetter() throws InvalidNifException {
            assertThrows(InvalidNifException.class, () -> new Nif(wrongNifControlLetter));
        }

        @Test
        public void incorrectNIE() throws InvalidNifException {
            assertThrows(InvalidNifException.class, () -> new Nif(wrongNifInvalidNIE));
        }

        @Test
        public void nullNif() throws InvalidNifException {
            assertThrows(InvalidNifException.class, () -> new Nif(wrongNifNullObject));
        }
    }

    @Nested
    @DisplayName("El constructor NO lanza InvalidNifException.")
    class doesNotThrowsExceptions{
        @Test
        public void correctDNI(){
            assertDoesNotThrow( () -> new Nif(correctNifDNI));
        }

        @Test
        public void correctNIE(){
            assertDoesNotThrow(() -> new Nif(correctNifNIE));
        }
    }


    @Test
    public void checkNIF() throws InvalidNifException {
        Nif dni = new Nif(correctNifDNI);
        Nif dni2 = new Nif(correctNifNIE);
        assertNotEquals(dni, dni2);
    }

    @Test
    public void checkString() throws InvalidNifException{
        Nif dni = new Nif(correctNifDNI);
        String str = new String("Nif{nif ciudadano= 12345678Z'}");
        assertEquals(str, dni.toString());
    }

}
