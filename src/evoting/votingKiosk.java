package evoting;

// Importamos únicamente las excepciones y las clases de paquete data que vayamos a utilizar
import data.*;
import evoting.biometricdataperipheral.HumanBiometricScanner;
import evoting.biometricdataperipheral.PassportBiometricReader;
import exceptions.*;
import services.ElectoralOrganism;

/**
 * Internal classes involved in the exercise of the vote
 */


public class votingKiosk {
    // ??? The class members
    // ??? The constructor/s
    // Input events
    private  String login;
    private Password pssw;

    private char selectedDocument;
    private String supportLogin;
    private String supportPassword;
    private char supportConfirmation;
    private Nif manualNif;
    private VotingOption selectedVotingOption;

    private BiometricData passpBioD;
    private BiometricData humanBioD;
    private char consent;
    PassportBiometricReader passportValidationService;
    HumanBiometricScanner humanBiometricScanner;
    SingleBiometricData faceBiometricData;
    SingleBiometricData fingerprintBiometricData;
    ElectoralOrganism electoralOrganism;
    boolean vote = false;

    public votingKiosk() {

    }

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

        if (humanBioD == null || passpBioD == null) throw new BiometricVerificationFailedException("Los datos proporcionados son nulos");

        if(!checkData(humanBioD,passpBioD)) throw new BiometricVerificationFailedException("Los datos no coinciden con la persona");

        System.out.println("Verificacion biometricca correcta");
        return;
    }

    public boolean checkData(BiometricData data1, BiometricData data2) {
        if(data1.getFaceBiometricData().getKeyData().length != data2.getFaceBiometricData().getKeyData().length &&
        data1.getFingerprintBiometricData().getKeyData().length != data2.getFingerprintBiometricData().getKeyData().length) {
            return false;
        }
        return true;
    }
    private void removeBiometricData () {
        // Hay que hacer
        humanBioD = null;
        passpBioD = null;
        System.out.println("Datos biometricos eliminados");
    }
    public void grantExplicitConsent (char cons) throws InvalidConsentException{
        if (cons != 's' || cons != 'S') throw new InvalidConsentException("Consentimiento explicito denegado");
        System.out.println("Consentimineto explicito otorgado");
        consent = cons;

    }
    public void readPassport () throws NotValidPassportException, PassportBiometricReadingException{
        passportValidationService.validatePassport();
        manualNif = passportValidationService.getNifWithOCR();
        passpBioD = passportValidationService.getPassportBiometricData();
        System.out.println("Lectura de pasaporte correcta");
    }
    public void readFaceBiometrics () throws HumanBiometricScanningException{
        faceBiometricData = humanBiometricScanner.scanFaceBiometrics();
        System.out.println("Lectura biometrica facial ");


    }
    public void readFingerPrintBiometrics () throws NotEnabledException, HumanBiometricScanningException, BiometricVerificationFailedException, ConnectException{
        fingerprintBiometricData = humanBiometricScanner.scanFingerprintBiometrics();
        humanBioD = new BiometricData(faceBiometricData,fingerprintBiometricData);
        verifiyBiometricData(humanBioD,passpBioD);
        System.out.println("Lectura de datos biométricos correcta.");
        // Eliminación de datos biometricos
        removeBiometricData();
        electoralOrganism.canVote(manualNif);
        vote = true;
        electoralOrganism.disableVoter(manualNif);

    }


}

