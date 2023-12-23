package services;

// Importamos únicamente las excepciones y las clases de paquete data que vayamos a utilizar
import data.Nif;
import exceptions.ConnectException;
import exceptions.NotEnabledException;

/**
 * External services involved in managing the electoral roll
 */
public interface ElectoralOrganism { // External service for the Electoral Organism
    void canVote(Nif nif) throws NotEnabledException, ConnectException;
    void disableVoter(Nif nif) throws ConnectException;
}
