package doubles;

import data.Nif;
import exceptions.ConnectException;
import exceptions.NotEnabledException;
import services.ElectoralOrganism;

public class ElectoralOrganismServiceFailedConnection implements ElectoralOrganism {

    private boolean failed;
    public ElectoralOrganismServiceFailedConnection(boolean failed) {
        this.failed = failed;
    }
    @Override
    public void canVote(Nif nif) throws NotEnabledException, ConnectException {
        if(failed) throw new ConnectException("Error al conectarse al socket/direccion/puerto");
    }

    @Override
    public void disableVoter(Nif nif) throws ConnectException {
        if(failed) throw new ConnectException("Error al conectarse al socket/direccion/puerto");
    }
}
