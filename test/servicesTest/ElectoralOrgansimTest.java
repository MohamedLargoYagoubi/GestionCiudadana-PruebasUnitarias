import data.Nif;
import exceptions.InvalidNifException;
import exceptions.NotEnabledException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import services.ElectoralOrganism;


interface ElectoralOrganismTest {

    ElectoralOrganism getElectoralOrganism();

    @Test
    default void testCanVote() throws InvalidNifException {
        Nif nif = new Nif("12345678Z"); // Replace with actual NIF
        try {
            getElectoralOrganism().canVote(nif);
        } catch (NotEnabledException | exceptions.ConnectException e) {
            Assertions.fail("Voter should be enabled", e);
        }
    }

    @Test
    default void testDisableVoter() throws InvalidNifException, exceptions.ConnectException {
        Nif nif = new Nif("12345678Z"); // Replace with actual NIF
        getElectoralOrganism().disableVoter(nif);
        try {
            getElectoralOrganism().canVote(nif);
            Assertions.fail("Expected NotEnabledException to be thrown");
        } catch (NotEnabledException e) {
            Assertions.fail("Voter should disabled", e);
        }
    }
}
