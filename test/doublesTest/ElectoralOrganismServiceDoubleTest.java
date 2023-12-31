import data.Nif;
import doubles.ElectoralOrganismServiceFailedConnection;
import doubles.ElectoralOrganismServiceIncorrect;
import doubles.ElectoralOrganismServiceOk;
import doublesTest.interfaces.ElectoralOrganismServiceInterfaceTest;
import exceptions.ConnectException;
import exceptions.InvalidNifException;
import exceptions.NotEnabledException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.ElectoralOrganism;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ElectoralOrganismServiceDoubleTest implements ElectoralOrganismServiceInterfaceTest {

    ElectoralOrganism electoralOrganismok;
    ElectoralOrganism electoralOrganismInvavalid;
    Nif validNif;
    Nif invalidNif;
    @BeforeEach
    public void SetUp() throws InvalidNifException {
        electoralOrganismok = new ElectoralOrganismServiceOk();
        validNif = new Nif("12345678Z");
        electoralOrganismInvavalid = new ElectoralOrganismServiceIncorrect();
        invalidNif = new Nif("Z7136488F");

    }

    @Override
    @Test
    public void canVoteValidNifTest() {
        assertDoesNotThrow(() -> electoralOrganismok.canVote(validNif));
    }

    @Override
    @Test
    public void cantVoteNullNifTest() throws NotEnabledException {
        assertThrows(NotEnabledException.class, () -> electoralOrganismInvavalid.canVote(invalidNif));
    }

    @Override
    @Test
    public void okConnectionTest() {
        assertDoesNotThrow(() -> new ElectoralOrganismServiceFailedConnection(true));
    }

    @Override
    @Test
    public void failedConnectionTest() throws ConnectException {
        assertThrows(ConnectException.class, () -> new ElectoralOrganismServiceFailedConnection(false));
    }

    @Override
    @Test
    public void disableNifTest() {
        assertDoesNotThrow(() -> electoralOrganismok.disableVoter(validNif));
    }
}
