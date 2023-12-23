package services;
// Importamos las clases del paquete data y de utils que vayamos a utilizar
import data.VotingOption;
import java.util.List;

public interface Scrutiny { // Centralizes the vote counting
    void initVoteCount (List<VotingOption> validParties);
    void scrutinize (VotingOption vopt);
    int getVotesFor (VotingOption vopt);
    int getTotal ();
    int getNulls ();
    int getBlanks ();
    void getScrutinyResults ();
}