package doubles;

import data.Nif;
import exceptions.ConnectException;
import exceptions.NotEnabledException;
import services.ElectoralOrganism;

public class ElectoralOrganismServiceIncorrect implements ElectoralOrganism {

    @Override
    public void canVote(Nif nif) throws NotEnabledException, ConnectException {
        if(!(nif.isValidNIF(nif.getNif()))) throw new NotEnabledException("El votante ya ha votado o no está en un colegio electoral que le corresponde");
    }

    @Override
    public void disableVoter(Nif nif) throws ConnectException {
        if(!(nif.isValidNIF(nif.getNif()))) System.out.println("Votante no puede ser inhabilitado");
    }
}
