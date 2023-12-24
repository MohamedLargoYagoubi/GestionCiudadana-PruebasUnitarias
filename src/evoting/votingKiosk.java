package evoting;

// Importamos únicamente las excepciones y las clases de paquete data que vayamos a utilizar
import data.BiometricData;
import data.Nif;
import data.Password;
import data.VotingOption;
import exceptions.*;

/**
 * Internal classes involved in the exercise of the vote
 */
public class votingKiosk {
    // ??? The class members
    // ??? The constructor/s
    // Input events
    public void initVoting () {
        // Hay que hacer
    }
    public void setDocument (char opt) {
        // Hay que hacer
    }
    public void enterAccount (String login, Password pssw) throws InvalidAccountException {
        // Hay que hacer
    }
    public void confirmIdentif (char conf) throws InvalidDNIDocumException {
        // Hay que hacer
    }
    public void enterNif (Nif nif) throws NotEnabledException, ConnectException{
        // Hay que hacer
    }
    public void initOptionsNavigation () {
        // Hay que hacer
    }
    public void consultVotingOption (VotingOption vopt) {
        // Hay que hacer
    }
    public void vote () {
        // Hay que hacer
    }

    public void confirmVotingOption (char conf) throws ConnectException {
        // Hay que hacer
        // Internal operation, not required
    }

    private void finalizeSession () {
        // Hay que hacer
    }

    // Setter methods for injecting dependences and additional methods

    private void verifiyBiometricData (BiometricData humanBioD, BiometricData passpBioD) throws BiometricVerificationFailedException {
        // Hay que hacer
    }
    private void removeBiometricData () {
        // Hay que hacer
    }
    public void grantExplicitConsent (char cons) {
        // Hay que hacer
    }
    public void readPassport () throws NotValidPassportException, PassportBiometricReadingException{
        // Hay que hacer
    }
    public void readFaceBiometrics () throws HumanBiometricScanningException{
        // Hay que hacer
    }
    public void readFingerPrintBiometrics () throws NotEnabledException, HumanBiometricScanningException, BiometricVerificationFailedException, ConnectException{
        // Hay que hacer
    }

}

