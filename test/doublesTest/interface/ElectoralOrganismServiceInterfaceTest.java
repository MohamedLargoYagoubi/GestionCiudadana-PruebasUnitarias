package interfaces;

import exceptions.ConnectException;
import exceptions.NotEnabledException;
import org.junit.jupiter.api.Test;

public interface ElectoralOrganismServiceInterfaceTest {

    @Test
    void canVoteValidNifTest();

    @Test
    void cantVoteNullNifTest() throws NotEnabledException;

    @Test
    void okConnectionTest();

    @Test
    void failedConnectionTest() throws ConnectException;

    @Test
    void disableNifTest();

}
