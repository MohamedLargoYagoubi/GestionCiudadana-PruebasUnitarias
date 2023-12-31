package doubles;

import data.Nif;
import evoting.votingKiosk;
import exceptions.ConnectException;
import exceptions.NotEnabledException;
import services.ElectoralOrganism;


public class ElectoralOrganismServiceOk implements ElectoralOrganism {

    @Override
    public void canVote(Nif nif) throws NotEnabledException, ConnectException {
        if((nif.isValidNIF(nif.getNif()))) System.out.println("El votante puede votar");
    }
    @Override
    public void disableVoter(Nif nif) throws ConnectException {
        if(nif.isValidNIF(nif.getNif())) System.out.println("Votante inhabilitado");
    }
}
